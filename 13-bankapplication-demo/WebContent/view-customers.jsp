<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Customers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <style>
        html, body {
            height: 100%;
            margin: 0;
        }
        body {
            background-image: url('https://1.bp.blogspot.com/-Qx20RdDxM_s/Vlr2BGt4p7I/AAAAAAAAATo/ypQV7f7jm9I/s1600/InsertPic_-795874.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            font-family: sans-serif;
        }
        .container {
            margin-top: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            padding: 20px;
        }
        table {
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .back-button {
            position: absolute;
            top: 20px;
            right: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Customer List</h2>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Account Number</th>
                    <th>Balance</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customersList}">
                    <tr>
                        <td>${customer.key.customer_id}</td>
                        <td>${customer.key.first_name}</td>
                        <td>${customer.key.last_name}</td>
                        <td>${customer.value.account_number}</td>
                        <td>${customer.value.balance}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="search-customer.jsp" class="btn btn-success">Search</a>
    </div>
    <a href="admin.jsp" class="btn btn-danger back-button">Back</a>
</body>
</html>