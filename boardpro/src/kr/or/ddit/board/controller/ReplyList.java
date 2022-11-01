package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

@WebServlet("/replyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		//service객체
		IBoardService service = BoardServiceImpl.getInstance();
		//service메소드 호출
		List<ReplyVO> list = service.listReply(bonum);
		
		//request에 저장
		request.setAttribute("list", list);
		
		//view페이지로 이동
		request.getRequestDispatcher("view/replyList.jsp").forward(request, response);
	}

}
