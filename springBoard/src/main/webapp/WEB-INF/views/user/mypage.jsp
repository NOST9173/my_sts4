<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
</head>
<body>
	<h2>My Page	</h2>
	
<!-- <hr> -->
	midx : ${vo.midx}<br>
	id : ${vo.id}<br>
	password : ${vo.password}<br>
	name : ${vo.name}<br>

	<button onclick="location.href='modify.do?midx=${vo.midx}'">수정</button>

<!-- <hr> -->
	
	
	
<%-- 

<div style="margin-top:30px; margin-left:auto; margin-right:auto; width:1400px; vertical-align:center;">
	<div style="display:inline; float:left;">
				
			<div style=" border-radius:12px; border:solid 1px #CCC; font-size:2em;  width:400px; height:480px;">
				<p style="margin-left:50px; ">
					<c:if test="${login != null }">
						${login.name} 님 환영합니다. <br> 마이 페이지 입니다.
					</c:if>
				</p>
				<div style="text-align:center;">
				</div>
			</div>
	</div>
	<div style=" display:inline-block; font-size:1.5em; margin-left:50px; margin-bottom:50px;">
		<div style=" border-radius:12px;border:solid 1px #CCC; width:700px;">
			<div class="member_id">
				<p style="margin-left:50px;">
					<c:if test="${login != null }">
							회원님의 midx : ${vo.midx}
					</c:if>
				</p>
			</div>
		</div>
	</div>
	<br>
	<div style=" display:inline-block; font-size:1.5em; margin-left:50px; margin-bottom:50px;">
		<div style=" border-radius:12px;border:solid 1px #CCC; width:700px;">
			<div class="member_email">
				<p style="margin-left:50px;">
					<c:if test="${login != null }">
						회원님의 id   : ${vo.id}
					</c:if>
				</p>
			</div>
		</div>
	</div>
	<br>
	<div style=" display:inline-block; font-size:1.5em; margin-left:50px; margin-bottom:50px;">
		<div style=" border-radius:12px;border:solid 1px #CCC; width:700px;">
			<div class="member_email">
				<p style="margin-left:50px;">
					<c:if test="${login != null}">
						회원님의 pwd   : ${vo.password}
					</c:if>
				</p>
			</div>
		</div>
	</div>
</div>
<br>

<form name="">
	<div style="text-align: center; margin-right:auto;">
		<c:if test="${login != null}">
			<a href="">회원수정</a>
			<a href="">회원탈퇴</a>
			<a href="logout.do">로그아웃</a>
		</c:if>
	</div>
</form> --%>


</body>
</html>