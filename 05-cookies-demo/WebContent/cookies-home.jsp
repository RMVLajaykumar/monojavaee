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
	String favLanguage = "java";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie c : cookies) {
			if (c.getName().equals("favoriteLang")) {
		favLanguage = c.getValue();
		break;
			}
		}
	}
	%>

	
		<h2>Your prefered language is<%=favLanguage%></h2>
	<a href="cookies-form.jsp">change your favorite language</a>

</body>
</html>