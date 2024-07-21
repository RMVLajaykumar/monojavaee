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





@WebServlet("/JDBCDemo")
public class JDBCDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
		    Statement state=conn.createStatement();
//			String insertQuery="insert into student1(rollnumber,name,pecentage)"+"values(7,'ronaldo',90),(18,'virat',98)";
//			int executeUpdate= state.executeUpdate(insertQuery);
//		
//			String query="delete from student1 where rollnumber=12";
//			int executeUpdate= state.executeUpdate(query);
//			
//		    System.out.println("number of rows  affected"+executeUpdate);
//		
		     String selectQuery = "select * from student1";
		     ResultSet rs=state.executeQuery(selectQuery);
		     
		     
		     while(rs.next()) {
		    	 int rollnumber = rs.getInt("rollnumber");
		    	 System.out.println(rollnumber);
		    	 System.out.println("------------");
		    	 String name=rs.getString("name");
		    	 System.out.println(name);
		    	 System.out.println("__________");
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
