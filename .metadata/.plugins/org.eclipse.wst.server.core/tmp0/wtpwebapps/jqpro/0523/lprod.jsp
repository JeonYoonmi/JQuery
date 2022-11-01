<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//요청시 데이터 받기
	
	//crud처리 - SqlMapClient가 필요
	SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	
	//mapper를 통해서 sql문 실행
	List<LprodVO> list = client.queryForList("lprod.selectAll"); 
	
	//list결과 응답 데이터 생성 - json Object 배열
%>

[
<%
	for(int i=0; i<list.size(); i++){
		LprodVO vo = list.get(i);
		if(i>0) out.print(",");
%>
	{
		"id" : "<%= vo.getLprod_id() %>",
		"gu" : "<%= vo.getLprod_gu() %>",
		"nm" : "<%= vo.getLprod_nm() %>"
	}
<%
	}
%>
]