<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
	<h2>게시글 작성</h2>
	<hr>
	
	<form action="write.do" method="post">
		<table>
			<tbody>
				<tr>
					<th align="right">
						 제목 : 
					</th>
					<td>
						<input type="text" name="title">
					</td>
				</tr>
				<tr>
					<th align="right">
						 내용 :
					</th>
					<td>
					<textarea cols="50" rows="10" name="content" placeholder="내용 작성하세요."></textarea>
					</td>	
				</tr>
			</tbody>
		</table>
		<button>저장</button>
	</form>
	
	
	
</body>
</html>