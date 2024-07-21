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
	<%
		String[] degrees = { "BE", "BTECH", "BCOM", "BMS" };
	  pageContext.setAttribute("theDegrees", degrees);
	%>
	<c:forEach var="degree" items="${theDegrees}">
     ${degree}<br />
	</c:forEach>


</body>
</html>