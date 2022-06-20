<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%
	String name = (String) request.getAttribute("name");
	int age = (Integer) request.getAttribute("age");
	String addr = (String) request.getAttribute("addr");
	String phone = (String) request.getAttribute("phone");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%=name %><br>
<%=age %><br>
<%=addr %><br>
<%=phone %><br> --%>
	
	${vo.name}<br>
	${vo.age}<br>
	${vo.addr}<br>
	${vo.phone}<br>

</body>
</html>