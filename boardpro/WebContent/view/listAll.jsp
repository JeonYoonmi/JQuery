<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//서블릿에서 공유데이터 가져온다.
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");

	Gson gson = new Gson();
	String result = gson.toJson(list);
	
	out.print(result);
	out.flush();	//jsp에 있는 내장 객체 => 비우기
	//jsp에서 json을 직접 만들면 원하는 이름으로 지정할 수 있지만 gson으로 하면 vo에 있는 이름 그대로로 만들어진다.
%>

<%-- 
[
	<%
		for(int i=0; i<list.size(); i++){
			BoardVO vo = list.get(i);
			if(i>0) out.print(',');
	%>
			{
				"num" : "<%= vo.getNum() %>",
				"subject" : "<%= vo.getSubject() %>",
				"password" : "<%= vo.getPassword() %>",
				"writer" : "<%= vo.getWriter() %>",
				"hit" : "<%= vo.getHit() %>",
				"mail" : "<%=vo.getMail() %>",
				"wdate" : "<%= vo.getWdate() %>",
				"content" : "<%=vo.getContent() %>"
			}
	<%
		}
	
	%>
] --%>