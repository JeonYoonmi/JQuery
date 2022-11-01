<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
p {
	font-size : 2.0em;
	font-weight: bold
}

span {
	color: red;
}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String userId = request.getParameter("id");
	String userName = request.getParameter("name");
	
	//crud 처리 - 결과를 응답한다. - text 형식
	
%>

<p><%= userId %>님 환영합니다.</p>
<p><%= userName %>님 <span>건강하고 행복하세요. 건행~~</span></p>

</body>
</html>