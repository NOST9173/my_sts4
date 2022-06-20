<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h2>로그인 화면</h2>
	<hr>
	<form action="login.do" method="post">
		id : <input type="text" name="id">
		pwd : <input type="password" name="password">
		<input type="submit" value="로그인">
	</form>

</body>
</html>