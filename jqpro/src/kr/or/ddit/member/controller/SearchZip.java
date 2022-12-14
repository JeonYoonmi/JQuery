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
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class SearchZip
 */
@WebServlet("/SearchZip.do")
public class SearchZip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchZip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 전송 데이터 받기 - dong
		String dong = request.getParameter("dong");
		
		//service객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		//service메소드 호출 - 결과값 받기
		List<ZipVO> list = service.selectByDong(dong);
		
		//결과값 출력 - view페이지로 이동
		request.setAttribute("dvalue", list);
		
		//request객체에 결과값을 저장한다.
		request.getRequestDispatcher("0525/searchzip.jsp").forward(request, response);
		
	}

}
