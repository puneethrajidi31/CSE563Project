<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
  <div class="text-center">
 
<form action="addUser" style="border:1px solid #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email:</b></label>
    <input type="text" placeholder="Enter Email" name="emailId" required><br><br>

    <label for="psw"><b>Password:</b></label>
    <p>Password should be in 6-12 Characters</p>
    <input type="password" placeholder="Enter Password" name="password" required><br><br>

    <label for="psw-repeat"><b>Re-enter Password:</b></label>
    <input type="password" placeholder="Repeat Password" name="reEnteredPassword" required><br><br>

    <label for="Roles"><b>Choose your Designation:</b></label>

    <select name="role" id="role">
      <option value="Manager">Manager</option>
      <option value="Employee">Employee</option>
    </select><br><br>
    <button type="submit" class="signupbtn">Sign Up</button><br><br>
  </div>
  <label>Already registered? please </label>
  <a href="login.jsp">LOGIN</a>
</form>
</div>
</body>
</html>