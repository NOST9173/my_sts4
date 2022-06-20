<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
</head>
<body>
	<h2>회원가입 화면입니다.</h2>
	<hr>
	<!-- join.do 앞에 / 가 있으면 도메인 뒤에 연결되어 넘어감. -->
	<form action="join.do" method="post">
		id : <input type="text" name="id"><br>
		password : <input type="password" name="password"><br>
		name : <input type="text" name="name"><br>
		<input type="submit" value="회원가입">
	</form>

</body>
</html>


















