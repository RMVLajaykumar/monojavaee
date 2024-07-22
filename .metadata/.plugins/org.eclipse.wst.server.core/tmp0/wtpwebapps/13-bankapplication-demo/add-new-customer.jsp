<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add New Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa; /* Changed background color for the body */
            font-family: sans-serif;
        }
        .navbar {
            background-color: #007bff; /* Blue background for the heading */
            position: relative;
            color: white; /* White text color */
        }
        .navbar .display-5 {
            color: white; /* Ensure text color is white */
        }
        .card {
            border-radius: 10px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }
        .form-group label {
            font-weight: bold;
        }
        .logout-button {
            position: absolute;
            top: 10px;
            right: 10px;
            color: white; /* Ensure text color is white */
        }
    </style>
</head>
<body>
    <nav class="navbar bg-primary">
        <div class="container-fluid d-flex justify-content-center align-items-center">
            <h1 class="display-5">Add New Customer</h1>
            <a href="logout" class="btn btn-danger logout-button">Logout</a>
        </div>
    </nav>
    <hr />
    <div class="container">
        <div class="card w-50 mx-auto my-5">
            <div class="card-body">
                <form action="admin" method="post">
                    <input type="hidden" name="command" value="add" />
                    <div class="form-group mb-3">
                        <label>First Name</label>
                        <input type="text" class="form-control" name="customer-fname" placeholder="Enter first name" required />
                    </div>
                    <div class="form-group mb-3">
                        <label>Last Name</label>
                        <input type="text" class="form-control" name="customer-lname" placeholder="Enter last name" required />
                    </div>
                    <div class="form-group mb-3">
                        <label>Email Address</label>
                        <input type="email" class="form-control" name="customer-email" placeholder="Enter email" required />
                    </div>
                    <div class="form-group mb-3">
                        <label>Password</label>
                        <input type="password" class="form-control" name="customer-password" placeholder="Enter password" required />
                    </div>
                    <input type="submit" class="btn btn-primary" value="Add customer">
                    <a href="admin" class="btn btn-danger ms-2">Back</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
