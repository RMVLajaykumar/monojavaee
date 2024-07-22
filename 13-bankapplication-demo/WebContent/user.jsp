<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <style>
        .navbar-brand-center {
            flex: 1;
            text-align: center;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <div class="container-fluid d-flex justify-content-between">
            <div class="navbar-brand-center">
                <h1 class="navbar-brand  mb-0">Bank Application</h1>
            </div>
            <div class="d-flex">
                <a href="logout" class="btn btn-danger">Logout</a>
            </div>
        </div>
    </nav>
    <hr />
    <nav class="navbar bg-primary">
        <div class="container-fluid d-flex justify-content-center align-items-center">
            <h1 class="navbar-brand my-2 ">Welcome to Customer Home</h1>
        </div>
    </nav>
    <nav class="navbar navbar-expand-lg bg-white px-5">
        <div class="container-fluid">
            <a class="navbar-brand nav-link" href="user?command=passbook">Passbook</a>
            <a class="navbar-brand nav-link" href="user?command=newtransaction">New Transactions</a>
            <a class="navbar-brand nav-link" href="user?command=editProfile">Edit Profile</a>
        </div>
    </nav>
    <hr>
    <div class="text-center mt-4">
        <img src="https://zeroonesh.com/wp-content/uploads/2021/03/banking-management2.jpg" class="rounded img-fluid" alt="Bank Image" width="50%" />
    </div>
</body>
</html>
