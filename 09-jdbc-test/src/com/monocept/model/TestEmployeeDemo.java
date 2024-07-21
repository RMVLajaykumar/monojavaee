package com.monocept.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/TestEmployeeDemo")
public class TestEmployeeDemo extends HttpServlet {
	@Resource(name="jdbc/employees")
	 private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = dataSource.getConnection();
//		  String query= "insert into employee values(?,?,?)";
//           PreparedStatement state = conn.prepareStatement(query);
//          state.setInt(1,5);
//          state.setString(2, "manibabu");
//          state.setInt(3, 10001);
//          state.addBatch();
//          state.setInt(1,6);
//          state.setString(2, "mani");
//          state.setInt(3, 10002);
//          state.addBatch();
//          int[] executeUpdate=state.executeBatch();
//          System.out.println("no of rows affected"+executeUpdate);
          
			String updateQuery = "update employee set id=? where salary=?";
			PreparedStatement state = conn.prepareStatement(updateQuery);
			state.setInt(1, 7);
			state.setDouble(2, 10002);
			int executeUpdate = state.executeUpdate();
			System.out.println("no of rows affected"+executeUpdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
