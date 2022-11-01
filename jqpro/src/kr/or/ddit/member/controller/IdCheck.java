package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class IdCheck
 * 
 * Servlet >> HttpServlet >> IdCheck
 * Servlet is a HttpServlet, HttpServlet is a IdCheck => Servlet is a IdCheck
 * //urlmapping
 */
@WebServlet("/idCheck.do")	
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : 요청받은 데이터, response : 전송할 데이터
		
		// 요청시 전송 데이터 받기 - 클라이언트가 폼에서 입력 한 id
		String userId = request.getParameter("id");
		
		//service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		//service메소드 호출하기 - 결과값 받기
		String res = service.selectById(userId);
		
		//결과값을 출력하기 - view페이지로 이동
		//view페이지로 이동하는 방법 - redirect : 서버 바깥으로 움직인다. => 데이터 값이 사라져서 jsp에 찍을 수 없다. 
		// forward : 서버 내에서 움직인다.
		
		request.setAttribute("resvalue", res);
		request.getRequestDispatcher("0525/idcheck.jsp").forward(request, response);	//request 안에 있는 메소드
		
		
		
	}

}














