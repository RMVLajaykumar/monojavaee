package com.monocept.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/TestConnectionpool")
public class TestConnectionpool extends HttpServlet {
	@Resource(name="jdbc/studentdb")
	 private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try (Connection conn =dataSource.getConnection();
		 Statement stmt = conn.createStatement();){
		String sql = "select * from student1";
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
		    System.out.println(rs.getString("name"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}

}
