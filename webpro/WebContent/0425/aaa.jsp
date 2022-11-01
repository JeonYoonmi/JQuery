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
			}
			
			table{
				border: 5px solid skyblue;
			}
			
			td{
				width: 200px;
				height: 50px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h1>JSP : Java Server Page</h1>
		HTML 코드에 JAVA 코드를 넣어 동적웹페이지를 생성하는 웹어플리케이션 도구이다.<br>
		
		JSP 가 실행되면 자바 서블릿(Servlet) 으로 변환되며 웹 어플리케이션 서버에서 동작되면서 필요한 기능을 수행하고<br>
		그렇게 생성된 데이터를 웹페이지와 함께 클라이언트로 응답한다.<br>
		
		<br>
		java코드는 &lt;%   %&gt; 기호 사이에 기술한다.<br>
		
		<%
			request.setCharacterEncoding("UTF-8"); //get방식일때는 안써도 되지만 post방식에서는 무조건 쓰기.
			String userId = request.getParameter("id");
			String userName = request.getParameter("name");
			String userTel = request.getParameter("tel");
			
			//db접속 = CRUD처리
		%>
		<br><br>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><%= userId %></td> <!-- %= 띄어쓰면 안됨 -->
			</tr>
			
			<tr>
				<td>이름</td>
				<td><%= userName %></td>
			</tr>
			
			<tr>
				<td>전화번호</td>
				<td><%= userTel %></td>
			</tr>
		</table>
	</body>
</html>