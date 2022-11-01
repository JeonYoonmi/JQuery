package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/searchDong.do")
public class SearchDong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("sido", sido);
		paramMap.put("gugun", gugun);
		
		
		
		IMemberService service = MemberServiceImpl.getInstance();
		request.setAttribute("dong", service.selectDongName(paramMap));
		request.getRequestDispatcher("HW/searchdong.jsp").forward(request, response);
		
	}

}
