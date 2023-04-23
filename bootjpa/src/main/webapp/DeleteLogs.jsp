<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
    <div class="text-center">
    <label><b>DELETE !!</b></label>
    <label>Give the id of the entered log that you want to delete and submit!!</label>
    <form action="delete">

    <label for="idval">ID:</label>
    <input type="text" id="idval" name="id"><br><br>

    <button type="submit" class="signupbtn">Delete</button><br><br>
    </form>
    <form><a href="http://localhost:8080/fetchrecords">Fetch Records</a></form><br><br>
    <form> <a href="ModifyLogs.jsp">Modify Records</a></form><br><br>
    <form> <a href="welcomeEmployee.jsp">Employee Home</a></form><br><br>
    <form> <a href="home.jsp">Login</a></form><br><br>
    </div>
</body>
</html>