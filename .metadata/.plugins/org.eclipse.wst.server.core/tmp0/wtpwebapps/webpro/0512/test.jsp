<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP : Java Sever Page</h1>
<%
	String userName = request.getParameter("name");
	String userId = request.getParameter("id");

%>

<%= userName %>님 환영합니다.<br>
<%= userId %>님 즐거운 하루 되세요.<br>

</body>
</html>