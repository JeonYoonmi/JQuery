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

@WebServlet("/modify.do")
public class BoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModify() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//요청시 전송데이터
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setWriter(request.getParameter("writer"));
		vo.setSubject(request.getParameter("subject"));
		vo.setPassword(request.getParameter("password"));
		vo.setMail(request.getParameter("mail"));
		vo.setContent(request.getParameter("content"));
		
		//Service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//service 메소드 호출하기 - 결과값 받기
		int res = service.modifyBoard(vo);
		
		//request에 결과값 저장하기
		request.setAttribute("result", res);
		
		//view페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
	}

}
