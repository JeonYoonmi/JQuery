package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/searchGugun.do")
public class SearchGugun extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sido = request.getParameter("sido");
		IMemberService service = MemberServiceImpl.getInstance();
		
		request.setAttribute("gugun", service.selectGugun(sido));
		request.getRequestDispatcher("HW/searchgugun.jsp").forward(request, response);
	}

}
