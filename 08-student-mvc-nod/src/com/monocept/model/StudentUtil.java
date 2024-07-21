package com.monocept.model;

import java.util.ArrayList;
import java.util.List;

public class StudentUtil {
	
	public static List<Student> getStudents(){
		
		List<Student> students= new ArrayList<Student>();
		
		students.add(new Student(1,"Ajay","kumar","rk@gmail.com"));
		students.add(new Student(2,"varish","v","vv@gmail.com"));
		students.add(new Student(3,"Shivamani","n","sn@gmail.com"));
		students.add(new Student(4,"tarun","c","tc@gmail.com"));
		students.add(new Student(5,"rishi","k","rishik@gmail.com"));
	
		 return students;
		
		
	}

}
