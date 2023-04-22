<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="loginUser" style="border:1px solid #ccc">
  <div class="container">
    <h1>Login</h1>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="emailId" required><br>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required><br>

    <button type="submit" class="signupbtn">Login</button>
    </div>
  </div>
</form>
</body>
</html>