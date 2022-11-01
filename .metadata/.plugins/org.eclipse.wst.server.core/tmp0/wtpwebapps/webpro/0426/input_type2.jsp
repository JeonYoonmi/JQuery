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
				border: 1px solid skyblue;
				margin: 10px auto;
			}
			
			td{
				width: 150px;
				height: 60px;
				text-align: center;
			}
			
/* 			p{ */
/* 				border : 1px dashed gray; */
/* 				width: 200px; */
/* 				height: 40px; */
/* 				margin: 10px; */
/* 				padding: 5px; */
/* 				font-size: 1.2em; */
/* 				text-align: center; */
/* 			} */
			
			.pp{
				float: left;
			}
			
			br{
				clear: both;
			}
		</style>
	</head>
	<body>
		<h1>JSP : Java Server Page</h1>
		
		<%
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String addr = request.getParameter("addr");
			String infile = request.getParameter("infile");
			String hidden = request.getParameter("hidden");
		%>
		
		<table border="1">
			<tr>
				<td >번호</td>
				<td><%=hidden %></td>
			</tr>
			
			<tr>
				<td>아이디</td>
				<td><%=name %></td>
			</tr>
			
			<tr>
				<td>전화번호</td>
				<td><%=tel %></td>
			</tr>
			
			<tr>
				<td>이메일</td>
				<td><%=email %></td>
			</tr>
			
			<tr>
				<td>주소</td>
				<td><%=addr %></td>
			</tr>
			
			<tr>
				<td>첨부파일</td>
				<td><%=infile %></td>
			</tr>
		</table>
		
<!-- 		<div> -->
<!-- 			<p class="pp">번호</p> -->
<%-- 			<p class="pp"><%=hidden %></p> --%>
<!-- 			<br> -->
		
<!-- 			<p class="pp">아이디</p> -->
<%-- 			<p class="pp"><%=name %></p> --%>
<!-- 			<br> -->
			
<!-- 			<p class="pp">전화번호</p> -->
<%-- 			<p class="pp"><%=tel %></p> --%>
<!-- 			<br> -->
			
<!-- 			<p class="pp">이메일</p> -->
<%-- 			<p class="pp"><%=email %></p> --%>
<!-- 			<br> -->
			
<!-- 			<p class="pp">주소</p> -->
<%-- 			<p class="pp"><%=addr %></p> --%>
<!-- 			<br> -->
			
<!-- 			<p class="pp">첨부파일</p> -->
<%-- 			<p class="pp"><%=infile %></p> --%>
<!-- 		</div> -->
	</body>
</html>