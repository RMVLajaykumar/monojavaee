<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Search Transactions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script>
        function toggleFields() {
            var searchBy = document.getElementById("searchBy").value;
            document.getElementById("accountFields").style.display = searchBy === "account" ? "block" : "none";
            document.getElementById("dateFields").style.display = searchBy === "date" ? "block" : "none";
        }
    </script>
</head>
<body>
    <form action="admin" method="post">
        <input type="hidden" name="command" value="searching" />
        <div class="mb-3">
            <label for="searchBy" class="form-label">Search By</label>
            <select id="searchBy" class="form-select" name="searchBy" onchange="toggleFields()">
                <option value="account">Account</option>
                <option value="date">Date</option>
            </select>
        </div>

        <div id="accountFields" style="display: block;">
            <div class="mb-3">
                <label for="sender_account_number" class="form-label">Enter the Sender's Account Number</label>
                <input type="text" class="form-control" id="sender_account_number" name="sender_account_number">
            </div>
            <div class="mb-3">
                <label for="receiver_account_number" class="form-label">Enter the Receiver's Account Number</label>
                <input type="text" class="form-control" id="receiver_account_number" name="receiver_account_number">
            </div>
        </div>

        <div id="dateFields" style="display: none;">
            <div class="mb-3">
                <label for="start_date" class="form-label">Enter the Start Date</label>
                <input type="date" class="form-control" id="start_date" name="start_date">
            </div>
            <div class="mb-3">
                <label for="end_date" class="form-label">Enter the End Date</label>
                <input type="date" class="form-control" id="end_date" name="end_date">
            </div>
        </div>

        <input type="submit" class="btn btn-primary" value="Search">
        <a href="admin" class="btn btn-danger">Back</a>
    </form>
</body>
</html>
