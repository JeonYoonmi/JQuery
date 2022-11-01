<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	h1{
		color: red;
		text-align: center;
	}
	
	table{
		margin: 10px auto;
		width: 500px;
		height: 300px;
		border: 3px solid skyblue;
	}
	
	td{
		text-align: center;
		font-size: 1.5em;
	}
	
	.name{
		width: 170px;
	}
</style>
</head>
<body>
	<h1>JSP : Java Server Page</h1>
	
	<%
	request.setCharacterEncoding("UTF-8");
	
	String userName = request.getParameter("name");
	String userTel = request.getParameter("tel");
	String userAddr = request.getParameter("addr");
	
	String[] userFlower = request.getParameterValues("flower");
	
	String str ="";
	for(String flower : userFlower){
		str += flower + " ";
	}
	%>
	
	<table border="1">
		<tr>
			<td class="name">이름</td>
			<td><%= userName %></td>
		</tr>
		
		<tr>
			<td class="name">전화번호</td>
			<td><%= userTel %></td>
		</tr>
		
		<tr>
			<td class="name">주소</td>
			<td><%= userAddr %></td>
		</tr>
		
		<tr>
			<td class="name">좋아하는 꽃들</td>
			<td><%= str %></td>
		</tr>
		
		
	</table>
	
</body>
</html>