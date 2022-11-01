<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table{
	border: 3px solid skyblue;
	margin: 10px auto;
}

td{
	text-align: center;
	width: 200px;
	height: 100px;
}

h1{
	color: red;
	width: 500px;
	height : 50px;
	margin: 10px auto;
	text-align: center;
}
</style>
</head>
<body>
<h1>JSP : Java Server Page</h1>

<%
	//한글 인코딩
	request.setCharacterEncoding("utf-8");

	//전송데이터 받기
	String userName = request.getParameter("name");
	String userMail = request.getParameter("mail");
	String userInfo = request.getParameter("area");	
	
	//userInfo 내용 속에는 엔터기호(\r\n)가 포함되어있다.
	//\r - 브라우저 기능이 없다.
	//\n - 브라우저에서 <br>기능을 수행
	
	String info ="";
	info = userInfo.replaceAll("\r", "").replaceAll("\n", "<br>");
%>

<table border="1">
	<tr>
		<td>이름</td>
		<td><%= userName %></td>
	</tr>

	<tr>
		<td>메일</td>
		<td><%= userMail %></td>
	</tr>

	<tr>
		<td>자기소개</td>
		<td><%= info %></td>
	</tr>

</table>
</body>
</html>