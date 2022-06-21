<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view page</title>
</head>
<body>

	<h2>게시글 상세화면 </h2>
	<table border="1">
	
		<tbody>
		<tr>
			<th align="right">글번호</th>
			<td>${vo.bidx }</td>
		</tr>
		<tr>
			<th align="right">작성자</th>
			<td>${vo.name }</td>
		</tr>
		<tr>
			<th align="right">작성일</th>
			<td>${vo.wdate }</td>
		</tr>
		<tr>
			<th align="right">제목</th>
			<td>${vo.title}</td>
		</tr>
		<tr>
			<th align="right">내용</th>
			<td>${vo.content}</td>
		</tr>
			
		</tbody>
	</table>
	<c:if test="${login.midx eq vo.midx}"> <!-- 로그인한 사람과 글쓴 사람이 맞는지 확인 후 수정, 삭제 버튼을 보여준다. -->
	<button>수정</button>
	<button>삭제</button>
	</c:if>
	<button onclick="location.href='list.do'">목록</button> 
</body>
</html>