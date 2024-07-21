package com.monocept.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student1Servlet
 */
@WebServlet("/Student1Servlet")
public class Student1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-students-jsp.jsp");
		List<Student> students = (List<Student>) request.getAttribute("theStudentList");
		System.out.println(students);
		requestDispatcher.forward(request, response);
	}

}
