package com.monocept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.monocept.entry.Student;

public class StudentDbUtil {
	
	private   DataSource datasource;

	public StudentDbUtil(DataSource datasource) {
		super();
		this.datasource = datasource;
	}

	public List<Student> getStudent() {
		
		List<Student> students=new ArrayList<Student>();
		try {
			Connection conn = datasource.getConnection();
			Statement state = conn.createStatement();
			
			String query = "select * from student1";
			ResultSet rs=state.executeQuery(query);
			
			while(rs.next()) {
				int rollnumber=rs.getInt("rollnumber");
				String name=rs.getString("name");
				int pecentage=rs.getInt("pecentage");
				
				Student student=new Student(rollnumber,name,pecentage);
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	public boolean addStudent(Student student) {
		
		
		try {
		      Connection conn = datasource.getConnection();
		      String sql = "insert into student1(name,pecentage) values(?,?)";
		      PreparedStatement prepStmt = conn.prepareStatement(sql);

		      prepStmt.setString(1, student.getName());
		      prepStmt.setInt(2, student.getPecentage());
		      int res = prepStmt.executeUpdate();

		      return res == 1 ? true : false;

		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return false;
		  }

	public  Student getStudent(int rollnumber) {
		try {
			Connection conn=datasource.getConnection();
			String query="select * from student1 where rollnumber=?";
			PreparedStatement state=conn.prepareStatement(query);
			
			state.setInt(1, rollnumber);
			ResultSet rs=state.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				int pecentage=rs.getInt("pecentage");
				Student student =  new Student(rollnumber,name,pecentage);
				return student;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateStudent(Student student) {
		
		try {
		      Connection conn = datasource.getConnection();
		      String sql = "update student1 set name=? , pecentage=? where rollnumber=?";
		      PreparedStatement prepStmt = conn.prepareStatement(sql);

		      prepStmt.setString(1, student.getName());
		      prepStmt.setInt(2, student.getPecentage());
		      prepStmt.setInt(3, student.getRollnumber());
		      
		      int res = prepStmt.executeUpdate();

		      return res == 1 ? true : false;

		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		
		return false;
	}

	public boolean deleteStudent(int rollnumber) {
		
		try {
			Connection conn=datasource.getConnection();
			String query="delete from student1 where rollnumber=?";
			PreparedStatement state=conn.prepareStatement(query);
			
			state.setInt(1, rollnumber);
			  int res = state.executeUpdate();

		      return res == 1 ? true : false;

		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
			
		
		return false;
	}

	public List<Student> searchStudent(String name) {
		List<Student> students = new ArrayList<>();
	
		try {
			Connection conn=datasource.getConnection();
			String query="select * from student1 where name=?";
			PreparedStatement state=conn.prepareStatement(query);
			
			state.setString(1, name);
			 ResultSet rs = state.executeQuery();
		        while (rs.next()) {
		            int rollnumber = rs.getInt("rollnumber");
		            int percentage = rs.getInt("pecentage");
		            Student student = new Student(rollnumber, name, percentage);
		            students.add(student);
		        }
		    } 
		        catch (SQLException e) {
		      e.printStackTrace();
		    }
		return students;
	
	}

	
	
}
