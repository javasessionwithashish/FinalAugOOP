<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

<h2>This is login page.</h2>
<hr>
<h3>Please Login: </h3>
<br>

<span style="color:green" > ${message} </span> 

<form method="post" action="login" >
Username: <input type="text" name="username" > <br><br>
Password: <input type="password" name="password"><br><br>

<input type="submit" value="LOGIN!!!!">
</form>

</body>
</html>