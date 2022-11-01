<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 공유 데이터 가져오기
	int num = (Integer) request.getAttribute("res");
	
	if(num > 0){
%>
		{
			"sw" : "ok"
		}
<%		
	}else{
%>
		{
			"sw" : "no"
		}
<%
	}
	
%>