<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>JSP : Java Server Page</h1>
		
		<%
		//한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		//전송데이터 받기 - id, name
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		%>
		
		<p>아이디 : <%= id %></p>
		<p>이름 : <%= name %></p>
	</body>
</html>