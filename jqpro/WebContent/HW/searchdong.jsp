<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<String> list = (List<String>)request.getAttribute("dong");
%>
[
	<%
		for(int i=0; i<list.size(); i++){
			String dong = list.get(i);
			if(i>0) out.print(",");
%>
			{
				"dong" : "<%= dong %>"
			}
<%
		}
	%>
]