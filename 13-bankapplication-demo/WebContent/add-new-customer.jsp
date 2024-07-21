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
            background-image: url("https://tse2.mm.bing.net/th?id=OIP.vdcDMKwke20rx-F7_CWcIQHaEK&pid=Api&P=0&h=180");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            font-family: sans-serif;
        }
        .navbar {
            background-color: #f5f5f5;
        }
        .card {
            border-radius: 10px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <nav class="navbar bg-white">
        <div class="container-fluid d-flex justify-content-center align-items-center">
            <h1 class="display-5">Add New Customer</h1>
        </div>
    </nav>
    <hr />
    <div class="container">
        <div class="card w-50 mx-auto my-5">
            <div class="card-body">
                <form action="customer" method="post">
                    <input type="hidden" name="action" value="add" />
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
                    <button type="submit" class="btn btn-primary">Add Customer</button>
                    <a href="admin.jsp" class="btn btn-danger ms-2">Back</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
