<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String favLang = request.getParameter("favLanguage");
	Cookie myCookie = new Cookie("favoriteLang", favLang);
	myCookie.setMaxAge(60 * 10);
	response.addCookie(myCookie);
	%>
	<hr>
	<h4>We set your Favorite language.Check your home page</h4>
	<a href="cookies-home.jsp">Cookie Home Page</a>


</body>
</html>