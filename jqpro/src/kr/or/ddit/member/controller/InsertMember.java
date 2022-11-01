package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/InsertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("mem_id");
		String userName = request.getParameter("mem_name");
		String userPass = request.getParameter("mem_pass");
		String userBir = request.getParameter("mem_bir");
		String userMail = request.getParameter("mem_mail");
		String userHp = request.getParameter("mem_hp");
		String userAdd1 = request.getParameter("mem_add1");
		String userAdd2 = request.getParameter("mem_add2");
		String userZip = request.getParameter("mem_zip");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(userId);
		vo.setMem_name(userName);
		vo.setMem_pass(userPass);
		vo.setMem_bir(userBir);
		vo.setMem_mail(userMail);
		vo.setMem_hp(userHp);
		vo.setMem_add1(userAdd1);
		vo.setMem_add2(userAdd2);
		vo.setMem_zip(userZip);
		
		//service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		//service메소드 호출
		String id = service.insertMember(vo);
		
		//결과값을 request에 저장
		request.setAttribute("resId", id);
		
		//view페이지로 이동
		request.getRequestDispatcher("0525/insert.jsp").forward(request, response);
		
	}

}
