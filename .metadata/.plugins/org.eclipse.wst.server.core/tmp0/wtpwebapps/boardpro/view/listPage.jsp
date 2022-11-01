<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.board.vo.PageVO"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 공유 데이터 가져오기
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
	PageVO vo = (PageVO)request.getAttribute("PageVO");

	JsonObject obj = new JsonObject();
	obj.addProperty("totalpage", vo.getTotalPage());
	obj.addProperty("startpage", vo.getStartPage());
	obj.addProperty("endpage", vo.getEndPage());
	
	Gson gson = new Gson();
	JsonElement elelist = gson.toJsonTree(list);
	
	obj.add("datas", elelist);
	
	out.print(obj);
	out.flush();
%>