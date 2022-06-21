<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 아래 한 줄이 있어야 jsp에서 jsp를 사용할 수 있다. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="true" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<body>

	<h2>게시판 목록</h2>
	
	<hr>
	
	<form method="get" action="list.do">
		<select name="searchType">
			<option value="title" <c:if test="${!empty searchVO.searchType and searchVO.searchType eq 'title'}"> selected</c:if>>제목</option>
			<option value="contentWriter" <c:if test="${!empty searchVO.searchType and searchVO.searchType eq 'title'}"> selected</c:if>>내용+작성자</option>
		</select>
		<input type="text" name="searchValue" <c:if test="${!empty searchVO.searchValue}">value="${searchVO.searchValue}"</c:if>>
		<input type="submit" value="검색">
	
	</form>
	
	<table border="1">
		<!-- 시멘틱 구조를 넣어서 만들어 줘야된다. -->
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<!-- 아래 조건문을 사용할 때 무조건 test에다가 넣어야 한다. -->
			<c:if test="${list.size()==0 }"> <!-- empty -> 내용이 비어져 있는지 확인하는  -->
				<tr>
					<td colspan="4">등록 된 게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${list.size()>0}">
				
				<c:forEach var="vo" items="${list }">
				<%-- <c:forEach begin="0" end="10" step="1"> --%>
					<tr>
						<td>${vo.bidx }</td>
						<td><a href="view.do?bidx=${vo.bidx}">${vo.title }</a></td>
						<td>${vo.name }</td>
						<td>${vo.wdate }</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<br>
	
	
	<!-- 로그인했을 때 보여주게 하는  -->
	<%--  <c:if test="${!empty login }">
	<button onclick="goWrite()">등록</button>
	 </c:if> --%>
	
	
	<button onclick="goWrite()">등록</button>
	
	<script>
		function goWrite(){
			var login = '${login}'; /* login 앞에 / 가 없기에 상대경로  */
			console.log();
			if(login != ""){
				location.href="write.do";	/* 링크는 무조건 get으로 보낸다.  */
			}else{
				alert("로그인 후 이용하실 수 있습니다.");
			}
		}
	</script>
	

</body>
</html>




















