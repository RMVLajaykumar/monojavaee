<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>Edit Profile</title>
<style>
  body {
    background-color: #f8f9fa;
  }
  .container {
    padding: 20px;
  }
  .header {
    background-color: #007bff;
    color: #fff;
    padding: 20px;
    border-radius: 8px;
  }
  .form-container {
    background-color: #ffffff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
  .btn-primary {
    background-color: #28a745;
    border-color: #28a745;
  }
  .btn-primary:hover {
    background-color: #218838;
    border-color: #1e7e34;
  }
  .btn-secondary {
    background-color: #6c757d;
    border-color: #6c757d;
  }
  .btn-secondary:hover {
    background-color: #5a6268;
    border-color: #545b62;
  }
  .btn-danger {
    background-color: #dc3545;
    border-color: #dc3545;
  }
  .btn-danger:hover {
    background-color: #c82333;
    border-color: #bd2130;
  }
  .form-group label {
    font-weight: bold;
  }
  .form-group input {
    border-radius: 5px;
  }
  .button-group {
    display: flex;
    gap: 10px; /* Space between buttons */
  }
  .logout-button {
    position: fixed;
    top: 20px;
    right: 20px;
  }
</style>
</head>
<body>
<div class="container mt-4">
  <div class="row justify-content-center">
    <div class="col-12">
      <div class="header text-center">
        <h1>Edit Profile</h1>
      </div>
    </div>
  </div>
  <a href="logout" class="btn btn-danger logout-button">Logout</a>
  <div class="row justify-content-center mt-4">
    <div class="col-lg-8 col-md-10 col-sm-12">
      <div class="form-container">
        <form action="user" method="post">
          <input type="hidden" name="command" value="editProfile">
          <div class="form-group mb-4"> 
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" placeholder="Enter First Name" value="${data.first_name}" name="first_name"> 
          </div>
          <div class="form-group mb-4"> 
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" placeholder="Enter Last Name" value="${data.last_name}" name="last_name">
          </div>
          <div class="form-group mb-4"> 
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Enter Password" value="${data.password}" name="password">
          </div>
          <div class="form-group mt-4 button-group">
            <button type="submit" class="btn btn-primary">Update</button>
            <button type="reset" class="btn btn-secondary">Cancel</button>
            <a href="user" class="btn btn-danger">Back</a>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
