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
        body {
            background-color: #f8f9fa; 
        }
        .container {
            margin-top: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            padding: 20px;
            position: relative;
        }
        .navbar {
            background-color: #007bff; 
            color: white;
        }
        .navbar h2 {
            color: white;
        }
        table {
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .logout-button {
            position: fixed;
            top: 20px;
            right: 20px;
        }
        .back-button {
            position: fixed;
            top: 80px;
            left: 20px;
        }
    </style>
</head>
<body>
    <nav class="navbar">
        <div class="container-fluid d-flex justify-content-center align-items-center">
            <h2>Transaction List</h2>
            <a href="logout" class="btn btn-danger logout-button">Logout</a>
        </div>
    </nav>
    <a href="user" class="btn btn-danger back-button">Back</a>
    <div class="container">
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
                        <c:if test="${transaction.transaction_type == 'Debited'}">
                            <td class="text-danger fw-5">-${transaction.transaction_amount}</td>
                        </c:if>
                        <c:if test="${transaction.transaction_type == 'Credited'}">
                            <td class="text-success fw-5">+${transaction.transaction_amount}</td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
