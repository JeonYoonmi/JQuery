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
			
			p{
				width: 200px;
				height: 50px;
				border: 1px dotted gray;
				font-size: 1.5em;
				margin: 20px;
				padding: 10px;
			}
			
			#p1{
				width: 80%;
			}
			
			.pp{
				float: left;	
			}
			
			#food{
				width: 500px;
			}
			
			br{
				clear: both;
			}
		</style>
	</head>
	<body>
		<h1>JSP : Java Server Page</h1>
		<p id="p1">request객체를 이용하여 클라이언트의 전송데이터를 받아서 처리한다.</p>
		
		<%
			//한글 인코딩 처리
			request.setCharacterEncoding("UTF-8");
			String userId = request.getParameter("id");
			String userName = request.getParameter("name");
			String userPass = request.getParameter("pass");
			String userGender = request.getParameter("gender");
			String[] foods = request.getParameterValues("like");
			
			String str = "";
			
			for(String food : foods){
				str += food + " ";
			}
		%>
		<div>
			<p class="pp">아이디</p>
			<p class="pp"><%= userId %></p>
			<br>
			
			<p class="pp">이름</p>
			<p class="pp"><%= userName %></p>
			<br>
			
			<p class="pp">비밀번호</p>
			<p class="pp"><%= userPass %></p>
			<br>
			
			<p class="pp">성별</p>
			<p class="pp"><%= userGender %></p>
			<br>
			
			<p class="pp">좋아하는 음식</p>
			<p class="pp" id="food"><%= str %></p>
			
		</div>
		
	</body>
</html>