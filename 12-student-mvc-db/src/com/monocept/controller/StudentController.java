package com.monocept.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.monocept.dao.StudentDbUtil;
import com.monocept.entry.Student;


@WebServlet("/Student")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private StudentDbUtil studentDbUtil;
	
   @Resource (name="jdbc/studentdb")
   private DataSource dataSource;
   
   @Override
   public void init() throws ServletException{
	   super.init();
	   studentDbUtil=new StudentDbUtil(dataSource);
	   
   }
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  command;
		command=request.getParameter("command");
		
		if(command==null) {
			command="list";
		}
		
		System.out.println(command);
		
		switch(command) {
		case "add":
			addStudent(request,response);
			break;
		case "load":
			loadStudent(request,response);
			break;
		case "update":
			updateStudent(request,response);
			break;
		case "delete":
			deleteStudent(request,response);
			break;
		case "search":
			searchStudent(request,response);
			break;
			
		default :	
			listStudent(request,response);
		
		}
	}
	private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
	    List<Student> students = studentDbUtil.searchStudent(name);
	    request.setAttribute("theStudentList", students);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("view-student.jsp");
	    dispatcher.forward(request, response);
	}



	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int rollnumber=Integer.parseInt(request.getParameter("rollnumber"));
		String name=request.getParameter("name");
		int percentageParameter=Integer.parseInt(request.getParameter("pecentage"));
		
		Student student=new Student(rollnumber,name,percentageParameter);
		boolean isUpdate=studentDbUtil.updateStudent(student);
		if(isUpdate) {
			 response.sendRedirect(request.getContextPath() + "/Student");	
		}
	}


	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int rollnumber=Integer.parseInt(request.getParameter("rollnumber"));
		boolean isDelete=studentDbUtil.deleteStudent(rollnumber);
		if(isDelete) {
			response.sendRedirect(request.getContextPath() + "/Student");		
		}
	}


	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int rollnumber=Integer.parseInt(request.getParameter("rollnumber"));
   
    Student student=studentDbUtil.getStudent(rollnumber);
    request.setAttribute("theStudent", student);
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-student.jsp");
	requestDispatcher.forward(request, response);
	}


	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String percentageParameter=request.getParameter("pecentage");
		int pecentage=0;
		try {
		if(percentageParameter!=null && !percentageParameter.isEmpty()) {
			pecentage=Integer.parseInt(percentageParameter);
			
		}
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		Student student = new Student(name,pecentage);
		System.out.println(student);
		
		boolean isAdded=studentDbUtil.addStudent(student);
		 System.out.println(isAdded);
		 if(isAdded) {
			 response.sendRedirect(request.getContextPath() + "/Student");
		 }
		 //listStudent(request,response);
		
	 }

	private void listStudent(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		List<Student> studentList = studentDbUtil.getStudent();
		System.out.println(studentList);
		request.setAttribute("theStudentList", studentList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-student.jsp");
		requestDispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}