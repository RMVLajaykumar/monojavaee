package com.monocept.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeJDBCdemo")
public class EmployeeJDBCdemo extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
		    Statement state=conn.createStatement();
//		    String insertQuery="insert into employee(id,name,salary)"+"values(2,'varish',10000),(3,'shivamani',10000),(4,'sumanth',10000)";
//			int executeUpdate= state.executeUpdate(insertQuery);
//			 System.out.println("number of rows  affected"+executeUpdate);
			 String selectQuery = "select * from employee";
		     ResultSet rs=state.executeQuery(selectQuery);
		     while(rs.next()) {
		    	 int id = rs.getInt("id");
		    	 System.out.println(id);
		    	 System.out.println("------------");
		    	 String name=rs.getString("name");
		    	 System.out.println(name);
		    	 System.out.println("__________");
		    	 double salary=rs.getDouble("salary");
		    	 System.out.println(salary);
		    	 System.out.println("- - - - - - -");
		     }
		     
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
