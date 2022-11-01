package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

@WebServlet("/replySave.do")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplySave() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송데이터 받기 - reply -> bonum, name, cont
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		String name = request.getParameter("name");
		String cont = request.getParameter("cont");
		
		ReplyVO vo = new ReplyVO();
		vo.setBonum(bonum);
		vo.setName(name);
		vo.setCont(cont);
		
		//service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//service메소드 호출 - 결과값 받기
		int res = service.insertReply(vo);
		
		//request결과값 저장
		request.setAttribute("res", res);
		
		//view페이지 이동
		request.getRequestDispatcher("/view/insert.jsp").forward(request, response);
		
	}

}
