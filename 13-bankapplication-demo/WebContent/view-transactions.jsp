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
            background-image: url('https://c93fea60bb98e121740fc38ff31162a8.s3.amazonaws.com/wp-content/uploads/2017/05/moneytransfer.jpg');
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
        <h2 class="text-center">Transaction List</h2>
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
        <a href="search-transaction.jsp" class="btn btn-success">Search</a>
    </div>
    <a href="admin.jsp" class="btn btn-danger back-button">Back</a>
</body>
</html>
