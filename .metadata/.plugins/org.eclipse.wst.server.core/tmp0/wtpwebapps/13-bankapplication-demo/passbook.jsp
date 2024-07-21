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
            background-image: url('https://www.idfcfirstbank.com/content/dam/idfcfirstbank/images/blog/savings-account/3-ways-to-get-new-bank-passbook-717X404.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-color: #f8f9fa;
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
            position: fixed;
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
    <a href="user.jsp" class="btn btn-danger back-button">Back</a>
</body>
</html>
