<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청시 데이터를 받아서
	SqlMapClient client = SqlMapClientFactory.getSqlMapClient();	//factory에서 client불러옴
	

	List<MemberVO> list = client.queryForList("member.selectAll");	//member.xml에 있는  <앞 : namespace이름 . 뒤 : 쿼리>
	
	
	//crud처리 한다.
	//처리결과로 응답데이터를 생성한다 - json object 배열
%>
[
	<%
		for(int i=0; i<list.size(); i++){
			MemberVO vo = list.get(i);
			
			if(i>0) out.print(",");	//처음에 ,를 븥이면 안되기 때문에 if문 넣어주기
	%>
	
	<%-- jsp형식 주석 / json 데이터에 주석을 달고 싶을 때는 % 주석처리 하기 --%>
	<%-- jsonobject배열 --%>
	{
		"id" : "<%= vo.getMem_id() %>",
		"name" : "<%= vo.getMem_name() %>",
		"hp" : "<%= vo.getMem_hp() %>",
		"mail" : "<%= vo.getMem_mail() %>",
		"addr" : "<%= vo.getMem_add1() %> <%= vo.getMem_add2() %>",
		"bir" : "<%= vo.getMem_bir() %>"
	}
	
	<%
		}
	%>
]
