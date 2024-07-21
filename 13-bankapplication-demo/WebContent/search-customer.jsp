<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Search Customer</title>
</head>
<body>
    <div class="container mt-5">
        <form action="customer">
            <input type="hidden" name="command" value="search"/>
            <div class="mb-3">
                <label for="customer_id" class="form-label">Enter the customerID to Search</label>
                <input type="text" class="form-control" id="customer_id" name="customer_id">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
            <a href="admin.jsp" class="btn btn-danger">Back</a>
        </form>
    </div>
</body>
</html>
