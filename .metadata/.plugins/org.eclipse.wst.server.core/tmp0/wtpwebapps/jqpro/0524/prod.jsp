<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청시 전송 데이터 가져오기
	String prod_lgu = request.getParameter("lgu");

	//crud - SqlMapClient 객체
	SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	
	//sql문을 실행 - mapper를 통해서
	List<ProdVO> list = client.queryForList("prod.selectLgu", prod_lgu);	//요청시 전송데이터 받아온거 꼭 넣기
	
	//처리결과로 응답데이터 생성 - json
// 	{
// 		"sw" : "ok",
// 		"datas" : [
// 		           {
// 		           	"id" :
// 		           	"name" :
// 		           },
// 		           {
// 			           	"id" :
// 			           	"name" :
// 			       }
// 		          ]
// 	}
	
// 	{
//		"sw" : "no"
//	}
	if(list != null && list.size() > 0){
%>
		{
			"sw" : "ok",
			"datas" : [
<%
			for(int i=0; i<list.size(); i++){
				ProdVO vo = list.get(i);
				if(i>0) out.print(",");
%>
				{
					"id" : "<%= vo.getProd_id() %>",
					"name" : "<%= vo.getProd_name() %>"
				}
<%
			}
%>
			]
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