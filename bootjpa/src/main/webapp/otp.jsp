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
<form action="addOTP" style="border:1px solid #ccc">
  
    <label for="otp"><b>Enter the OTP:</b></label>
    <input type="text" placeholder="Enter OTP" name="otpfromUser" required><br><br>

    <button type="submit" class="signupbtn">Submit</button><br><br>
</form>
<form> <a href="home.jsp">Login</a></form><br><br>
</div>
</body>
</html>