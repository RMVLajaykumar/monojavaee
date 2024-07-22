<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar bg-primary">
		<div class="container-fluid">
			<div class="d-flex justify-content-between align-items-center w-100">
				<h1 class="navbar-brand my-2 mx-auto">Bank Application</h1>
				<a href="logout" class="btn btn-danger">Logout</a>
			</div>
		</div>
	</nav>

	<hr />

	<nav class="navbar bg-primary">
		<div class="container-fluid d-flex justify-content-center align-items-center">
			<h1 class="navbar-brand my-2">Welcome to Admin Home</h1>
		</div>
	</nav>

	<nav class="navbar navbar-expand-lg bg-white px-5">
		<div class="container-fluid">
			<a class="navbar-brand nav-link" href="admin?command=addCustomer">Add New Customer</a> 
			<a class="navbar-brand nav-link" href="admin?command=viewCustomer">View Customers</a> 
			<a class="navbar-brand nav-link" href="admin?command=transaction">View Transactions</a>
		</div>
	</nav>

	<hr>

	<div class="text-center mt-4">
		<img
			src="https://zeroonesh.com/wp-content/uploads/2021/03/banking-management2.jpg"
			class="rounded img-fluid" alt="Bank-image" width="50%" />
	</div>

</body>
</html>
