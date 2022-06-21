<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 예제 </title>
											<!-- /resources/js/jquery-3.6.0.min.js 에서 가상 경로  -->
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<script>
	function userInfo(){
		
		/* 변수 설정. */
		var ptjPath = '<%=request.getContextPath() %>';
		
		$.ajax({
			url:ptjPath+'/ajax/userInfo.do',
			type:"get",
			success: function(data){
			/* 	$("#result").html(data); */
			
			console.log(data);
			$("#result").html(data.id+", "+data.name+", "+data.password+", "+data.midx);
			}
		});
	}

	function goText(){
		$.ajax({
			url:'goText.do',
			type:"get",
			data:"text="+$("#t1").val(),
			
			success:function(data){
				$("#result2").html(data);
				
			}
		});
	}
	
	
	function callBoard(){
		$.ajax({
			url: "boardList.do",
			type:"get",
			success:function(data){
				
				var html = "";
				
				html += "<table border='1'>";
				html += "<thead>";
				html += "<tr>";
				html += "<th>글 번호</th>";
				html += "<th>글 제목</th>";
				html += "<th>작성자</th>";
				html += "</tr>";
				html += "</thead>";
				html += "<tbody>";
				for(var i=0;i<data.length;i++){
					html+="<tr>";
					html+="<td>"+data[i].bidx+"</td>";
					html+="<td><a href='javascript:viewBoard("+data[i].bidx+");'>"+data[i].title+"</a></td>";
					html+="<td>"+data[i].name+"</td>";
					html+="</tr>";
				}
				
				html += "</tbody>";
				html += "</table>";
				
				$("#boardList").html(html);	
				
			}
		});
		
	}
	
	
	function viewBoard(bidx){
		$.ajax({
			url:"boardView.do",
			type:"get",
			data:"bidx="+bidx,
			success:function(data){
				
				var html = "";
				
				html += "글 번호 : " + data.bidx+"<br>";
				html += "제목 : " + data.title+"<br>";
				html += "내용 : " + data.content+"<br>";
				html += "작성자 : " + data.name+"<br>";
				html += "작성일 : " + data.wdate+"<br>";
	
				
				$("#boardView").html(html);
				
			}
			
			
		});
		
	}
	function searchGo(){
		$.ajax({
			url:"boardList.do",
			type:"get",
			data:$("#searchFrm").serialize(), // 셀렉터 form 안에 있는 name을 가지고 있는 모든 입력양식 데이터를 파라미터 문자열로 반환하는 역할.
			success:function(data){
					
				var html = "";
				html += "<table border='1'>";
				html += "<thead>";
				html += "<tr>";
				html += "<th>글 번호</th>";
				html += "<th>글 제목</th>";
				html += "<th>작성자</th>";
				html += "</tr>";
				html += "</thead>";
				html += "<tbody>";
				for(var i=0;i<data.length;i++){
					html+="<tr>";
					html+="<td>"+data[i].bidx+"</td>";
					html+="<td><a href='javascript:viewBoard("+data[i].bidx+");'>"+data[i].title+"</a></td>";
					html+="<td>"+data[i].name+"</td>";
					html+="</tr>";
				}
				
				html += "</tbody>";
				html += "</table>";
				
				$("#boardList").html(html);	
			}
			
			
		});
	}
</script>
</head>
<body>
	<h2>ajax 예제 페이지</h2>
	<hr>
	<button onclick="userInfo()">현재 로그인 유저 정보 확인 </button>
	<div id="result">
	
	</div>
	<hr></hr>
	<input type="text" id="t1">
	<button onclick="goText()">클릭!</button>
	<div id="result2">
	</div>
	<hr></hr>
	<button onclick="callBoard()">게시글 불러오기</button>
	<form id="searchFrm" >
		<select name="searchType">
			<option value="title" >제목</option>
			<option value="contentWriter" >내용+작성자</option>
		</select>
		<input type="text" name="searchValue" >
		<input type="button" value="검색" onclick="searchGo();">
	
	</form>
	
	<div id="boardList">
	
	</div>
	
	<hr>
	<div id="boardView">
	
	</div>

</body>
</html>
















