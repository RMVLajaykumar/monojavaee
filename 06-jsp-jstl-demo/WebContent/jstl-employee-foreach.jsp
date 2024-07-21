<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,java.util.ArrayList,com.monocept.entry.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Employee> employees = new ArrayList<>();
	employees.add(new Employee(1, "Mahesh", 10000));
	employees.add(new Employee(2, "suresh", 12344));
	employees.add(new Employee(3, "rajesh", 12345));
	employees.add(new Employee(4, "ramesh", 12350));
	employees.add(new Employee(5, "rakesh", 12300));
	pageContext.setAttribute("theemployees", employees);
	%>

	<table border=1>
		<tr>
			<td>emp id</td>
			<td>name</td>
			<td>salary</td>
			<td>salarytype</td>
		</tr>
		<c:forEach var="emp" items="${theemployees}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.salary}</td>
				<td>
				<c:if test="${emp.salary>10000}">
                  high
                 </c:if>
                 <c:if test="${emp.salary<=10000}">
                  low
                 </c:if>
                 </td>
			</tr>

		</c:forEach>



	</table>


</body>
</html>