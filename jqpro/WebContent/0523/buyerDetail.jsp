<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//요청시 데이터 받기 - id값
	String buyer_id = request.getParameter("id");
	
	//crud처리 - sqlMapClient가 필요
	SqlMapClient client = SqlMapClientFactory.getSqlMapClient();

	//mapper를 통해서 sql문 실행
	BuyerVO vo = (BuyerVO)client.queryForObject("buyer.buyerDetail", buyer_id);
%>

{
	"id" : "<%= vo.getBuyer_id() %>",
	"name" : "<%= vo.getBuyer_name() %>",
	"lgu" : "<%= vo.getBuyer_lgu() %>",
	"comtel" : "<%= vo.getBuyer_comtel() %>",
	"bank" : "<%= vo.getBuyer_bank() %>",
	"bno" : "<%= vo.getBuyer_bankno() %>",
	"bname" : "<%= vo.getBuyer_bankname() %>",
	"mail" : "<%= vo.getBuyer_mail() %>",
	"zip" : "<%= vo.getBuyer_zip() %>",
	"addr1" : "<%= vo.getBuyer_add1() %>",
	"addr2" : "<%= vo.getBuyer_add2() %>"
}