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

@WebServlet("/replyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyUpdate() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//요청시 전송 데이터 가져오기 - renum, cont
		int renum = Integer.parseInt(request.getParameter("renum"));
		String cont = request.getParameter("cont");

		ReplyVO vo = new ReplyVO();
		vo.setRenum(renum);
		vo.setCont(cont);
		
		//service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//service메소드 호출 - 결과값 받기
		int res = service.updateReply(vo);
		
		//request에 결과값 저장
		request.setAttribute("result", res);
		
		//view페이지로 이동 - result.jsp
		request.getRequestDispatcher("view/result.jsp").forward(request, response);
		
	}

}
