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
	height: 600px;
	border: 3px solid skyblue;
	text-align: center;
	
}

.t{
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>JSP : Java Server Page</h1>
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		String userName = request.getParameter("name");
		String userAddr = request.getParameter("addr");
		String userTel = request.getParameter("tel");
		
		String start1 = request.getParameter("start1");
		String end1 = request.getParameter("end1");
		String content1 = request.getParameter("content1");
		content1 = content1.replaceAll("\r", "").replaceAll("\n", "<br>");
		
		String start2 = request.getParameter("start2");
		String end2 = request.getParameter("end2");
		String content2 = request.getParameter("content2");
		content2 = content2.replaceAll("\r", "").replaceAll("\n", "<br>");
		
		String start3 = request.getParameter("start3");
		String end3 = request.getParameter("end3");
		String content3 = request.getParameter("content3");
		content3 = content3.replaceAll("\r", "").replaceAll("\n", "<br>");
		
		
	%>
	
	<table border="1">
		<tr>
			<td class="t">이름</td>
			<td colspan="2"><%= userName %></td>
		</tr>
		
		<tr>
			<td class="t">주소</td>
			<td colspan="2"><%= userAddr %></td>
		</tr>
		
		<tr>
			<td class="t">전화번호</td>
			<td colspan="2"><%= userTel %></td>
		</tr>
		
		<tr>
			<td class="t" rowspan="6">경력사항</td>
			<td class="t">기간</td>
			<td><%= start1 %> ~ <%= end1 %></td>
		</tr>
		
		<tr>
			<td class="t">내용</td>
			<td><%= content1 %></td>
		</tr>
		
		<tr>
			<td class="t">기간</td>
			<td><%= start2 %> ~ <%= end2 %></td>
		</tr>
		
		<tr>
			<td class="t">내용</td>
			<td><%= content2 %></td>
		</tr>
		
		<tr>
			<td class="t">기간</td>
			<td><%= start3 %> ~ <%= end3 %></td>
		</tr>
		
		<tr>
			<td class="t">내용</td>
			<td><%= content3 %></td>
		</tr>
		
		
		
	</table>
</body>
</html>