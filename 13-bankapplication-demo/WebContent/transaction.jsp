<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Transaction</title>
<style>
  body {
    background-color:
  }
  .container {
    padding: 2rem; 
  }
  .btn-primary {
    background-color: #007bff; 
    border-color: #007bff; 
  }
  .btn-primary:hover {
    background-color: #0056b3;
    border-color: #004085; 
  }
  .btn-danger {
    background-color: #dc3545; 
    border-color: #dc3545; 
  }
  .btn-danger:hover {
    background-color: #c82333; 
    border-color: #bd2130; 
  }
  .form-group {
    margin-bottom: 1.5rem; 
  }
  .logout-button {
    position: fixed;
    top: 20px;
    right: 20px;
  }
  .heading {
    background-color: #007bff; 
    color: white;
    padding: 10px;
    border-radius: 5px;
  }
</style>
</head>
<body>
  <div class="container mt-3">
    <div class="row justify-content-center">
      <div class="col-12">
        <div class="p-4 heading text-center">
          <h1>New Transaction</h1>
        </div>
      </div>
    </div>
    <a href="logout" class="btn btn-danger logout-button">Logout</a>
    <hr />
    <div class="row justify-content-center mt-3">
      <div class="col-lg-4">
        <div class="p-4 border bg-light text-center">
          <h2 class="mb-4">TRANSFER</h2>
          <form action="user" method="post">
            <input type="hidden" name="command" value="newtransaction"> 
            <div class="form-group mb-4">
                <label for="account_number">Account Number</label>
                <input type="text" class="form-control" id="account_number" name="receiver_account_number" placeholder="Enter receiver account number">
            </div>
            <div class="form-group mb-4">
                <label for="transaction_amount">Amount</label>
                <input type="text" class="form-control" id="transaction_amount" placeholder="Enter amount" name="transaction_amount">
            </div>
            <div class="form-group mt-4">
                <button type="submit" class="btn btn-primary mr-2">Transfer</button>
                <a href="user" class="btn btn-danger">Cancel</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
