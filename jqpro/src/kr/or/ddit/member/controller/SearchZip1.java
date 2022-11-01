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
import kr.or.ddit.member.vo.ZipVO;

@WebServlet("/searchZip1.do")
public class SearchZip1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		String dong = request.getParameter("dong");
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("sido", sido);
		paramMap.put("gugun", gugun);
		paramMap.put("dong", dong);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		List<ZipVO> list = service.selectZip(paramMap);
		
		request.setAttribute("zip", list);
		request.getRequestDispatcher("HW/searchzip1.jsp").forward(request, response);
		
	}

}
