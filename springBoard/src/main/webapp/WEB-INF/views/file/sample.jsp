<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload page</title>
</head>
<body>

	<h2>file upload 예제</h2>
	<hr>
	<form action="upload.do" method="post" enctype="multipart/form-data"> <!-- 파일같은 것은 무조건 post만 , 파일은 enctype 을 지정해줘야 한다. -->
		파일 : <input type="file" name="file">
		<br>
		<input type="submit" value="업로드">
	</form>

</body>
</html>