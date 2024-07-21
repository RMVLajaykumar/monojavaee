<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<div class="container mt-5">
		<h2 class="text-center">Student Details</h2>
		<hr>
		<p class="lead">First Name : <%= request.getParameter("firstname")%> </p>
		<p class="lead">Last Name : <%= request.getParameter("lastname")%> </p>
		<p class="lead">City : <%= request.getParameter("city")%> </p>
		<p class="lead">City : <%= request.getParameter("gender")%> </p>
		<h3>
			Languages : <small class="text-muted"> 
			<%
 			String[] languages = request.getParameterValues("Languages");
			if(languages!=null){
				String language=String.join(", ", languages);
				out.print(language);
			}
 			%>
			</small>
		</h3>
	</div>


</body>
</html>