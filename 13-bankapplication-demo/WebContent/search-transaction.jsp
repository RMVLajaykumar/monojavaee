<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="viewTransactionServlet">
    <input type="hidden" name="command" value="searching"/>
    <div class="mb-3">
        <label for="sender_account_number" class="form-label">Enter the customerID to Search</label>
        <input type="text" class="form-control" id="sender_account_number" name="sender_account_number">
    </div>
     <div class="mb-3">
        <label for="receiver_account_number" class="form-label">Enter the customerID to Search</label>
        <input type="text" class="form-control" id="receiver_account_number" name="receiver_account_number">
    </div>
    <input type="submit" class="btn btn-primary" value="Search">
    <a href="admin.jsp" class="btn btn-danger">Back</a>
</form>


</body>
</html>