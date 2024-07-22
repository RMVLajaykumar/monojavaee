<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Transactions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <style>
        html, body {
            height: 100%;
            margin: 0;
        }
        body {
            background-color: #f8f9fa; 
            font-family: sans-serif;
        }
        .navbar {
            background-color: #007bff; 
            position: relative;
            color: white;
        }
        .navbar .display-5 {
            color: white; 
        }
        .container {
            margin-top: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            padding: 20px;
            position: relative;
        }
        table {
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .button-group {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        .logout-button {
            position: absolute;
            top: 20px;
            right: 20px;
        }
    </style>
</head>
<body>
    <nav class="navbar bg-primary">
        <div class="container-fluid d-flex justify-content-center align-items-center">
            <h1 class="display-5">Transaction List</h1>
            <a href="logout" class="btn btn-danger logout-button">Logout</a>
        </div>
    </nav>
    <div class="container">
        <div class="button-group">
            <a href="search-transaction.jsp" class="btn btn-success">Search</a>
            <a href="admin" class="btn btn-danger">Back</a>
        </div>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Sender Account no</th>
                    <th>Receiver Account no</th>
                    <th>Transaction date</th>
                    <th>Transaction type</th>
                    <th>Amount</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaction" items="${transactionsList}">
                    <tr>
                        <td>${transaction.sender_account_number}</td>
                        <td>${transaction.receiver_account_number}</td>
                        <td>${transaction.date_of_transaction}</td>
                        <td>${transaction.transaction_type}</td>
                        <td>${transaction.transaction_amount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
