package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/write.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWrite() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//요청시 전송 데이터 받기
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String content = request.getParameter("content");
		
		//VO에 저장
		BoardVO vo = new BoardVO();
		vo.setWriter(writer);
		vo.setSubject(subject);
		vo.setPassword(password);
		vo.setMail(mail);
		vo.setContent(content);
		vo.setWip(request.getRemoteAddr());
		
		//service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//service 메소드 호출하기 - 결과값 받기
		int num = service.insertBoard(vo);
		System.out.println(num);
		//결과값을 request에 저장
		request.setAttribute("res", num);
		
		//view페이지로 이동 - 출력
		request.getRequestDispatcher("view/insert.jsp").forward(request, response);
		
	}
}
