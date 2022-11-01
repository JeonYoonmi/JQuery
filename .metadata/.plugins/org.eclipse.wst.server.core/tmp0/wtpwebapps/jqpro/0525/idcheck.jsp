<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//이 페이지에는 출력을 위한 내용만 있으면 된다 - view
	//서블릿에서 request에 저장한 데이터를 가져온다
	String str = (String)request.getAttribute("resvalue");

	if(str==null){
		//사용가능
%>
		{
			"sw" : "사용가능 아이디"
		}
<%		
	}else{
		//사용불가능
%>
		{
			"sw" : "사용 불가능 아이디"
		}
<%		
	}
	
%>