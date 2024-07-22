<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.monocept.entity.StringUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</head>
<body>
  welcome <%= StringUtil.toUpperCase("hello world") %>
	<div class="container mt-3">
		<h2 class="text-center">Todo's List</h2>
		<form action="demosession.jsp" method="get">
			<div class="col-sm-10 mb-3">
				<input type="text" name="item" class="form-control"
					placeholder="Enter a todo task">

			</div>
			<div class="col-sm-10">
				<input type="submit" value="ToDo" class="btn btn-primary">
			</div>
		</form>

		<hr>
		<%
		List<String> todoItemList=(List<String>)session.getAttribute("todoItem");
		if(todoItemList==null){
			todoItemList=new ArrayList<>();
			session.setAttribute("todoItem",todoItemList);
		}
		
		
			String todoItems = request.getParameter("item");
			 if(todoItems!=null&&!todoItems.trim().equals("")&&!todoItemList.contains(todoItems)){
				todoItemList.add(todoItems);
			}
			
			for(String s: todoItemList){
				out.println(s);
			}
			
		%>
		<ul class="list-group">
		</ul>
	</div>

</body>
</html>