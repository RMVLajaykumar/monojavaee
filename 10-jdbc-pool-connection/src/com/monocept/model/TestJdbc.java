package com.monocept.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/TestJdbc")
public class TestJdbc extends HttpServlet {
	@Resource(name="jdbc/studentdb")
	 private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = dataSource.getConnection();
//			String query= "insert into student1 values(?,?,?)";
//            PreparedStatement state = conn.prepareStatement(query);
//            state.setInt(1,5);
//            state.setString(2, "manibabu");
//            state.setInt(3, 75);
//            int executeUpdate=state.executeUpdate();
			String updateQuery="update student1 set pecentage=? where rollnumber=?";
			PreparedStatement state = conn.prepareStatement(updateQuery);
			state.setInt(1, 80);
			state.setInt(2, 5);
			 int executeUpdate=state.executeUpdate();
            System.out.println("no of rows affected"+executeUpdate);
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
