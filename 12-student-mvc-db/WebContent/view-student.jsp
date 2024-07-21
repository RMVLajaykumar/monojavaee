<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 class="text-center">List of Students</h2>



<table class="table table-dark table-striped">
		<tr>
			<td>rollnumber</td>
			<td>name</td>
			<td>percentage</td>
			<td>update</td>
			<td>delete</td>
			
		</tr>
		<c:forEach var="student" items="${theStudentList}" >
			<tr>
				<td>${student.rollnumber}</td>
				<td>${student.name}</td>
				<td>${student.pecentage}</td>
				<td>
				<a href="Student?command=load&rollnumber=${student.rollnumber}" class="btn btn-secondary">Update</a>
				</td>
				<td>
				<a href="Student?command=delete&rollnumber=${student.rollnumber}" class="btn btn-warning">Delete</a>
				</td>

				
			</tr>
	 </c:forEach>
	   <a href="search-student.jsp" class="btn btn-success" >Search</a>
	  <hr>
	 
	 </table>

          <a href="add-student.jsp" class="btn btn-primary">Add student</a>


</body>
</html>