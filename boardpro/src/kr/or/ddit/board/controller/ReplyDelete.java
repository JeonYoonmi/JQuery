package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

@WebServlet("/replyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 renum 데이터 받기
		int renum = Integer.parseInt(request.getParameter("renum"));
		
		//service 객체
		IBoardService service = BoardServiceImpl.getInstance();
		
		//service메소드 호출
		int res = service.deleteReply(renum);
		
		//request에 결과값 저장
		request.setAttribute("result", res);
		
		//view페이지 이동 - result.jsp로
		request.getRequestDispatcher("view/result.jsp").forward(request, response);
	}

}
