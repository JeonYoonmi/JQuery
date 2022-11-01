<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<String> list = (List<String>)request.getAttribute("sido");
%>
[
	<%
		for(int i=0; i<list.size(); i++){
			String sido = list.get(i);
			if(i>0) out.print(",");
%>
			{
				"sido" : "<%= sido %>"
			}
<%
		}
	%>
]