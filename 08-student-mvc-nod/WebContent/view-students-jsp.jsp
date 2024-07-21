<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h2>List of employees</h2>

<table border=1>
		<tr>
			<td>student id</td>
			<td>student firstname</td>
			<td>student lastname</td>
			<td>student emailid</td>
		</tr>
		<c:forEach var="student" items="${theStudentList}" >
			<tr>
				<td>${student.studentid}</td>
				<td>${student.firstname}</td>
				<td>${student.lastname}</td>
				<td>${student.emailId}</td>
				
			</tr>
	 </c:forEach>

</body>
</html>