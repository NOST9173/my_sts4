<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
</head>
<body>

	<h2>회원정보 수정 </h2>
	
	<form action="modify.do" method="post">
	<input type="hidden" name="midx" value="${vo.midx}">
		midx : ${vo.midx} <br><!-- 우리가 보낸 vo에서 가져와야해서 vo.midx로 사용  -->
		id : ${vo.id}<br>
		pwd : <input type="password" name="password" value="${vo.password}"><br>
		name : <input type="text" name="name" value="${vo.name}"><br>
		<input type="submit" value="저장">
	</form>

</body>
</html>