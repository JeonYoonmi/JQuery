package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

@WebServlet("/List.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//하나의 서블릿에서 두개의 기능을 할 수 있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체 리스트 출력
		
		//요청시 전송 데이터 받기
		
		//servlet객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//servlet 메소드 호출하기 - 결과값 받기
		List<BoardVO> list = service.selectAll();
		
		//결과 값을 request에 저장
		request.setAttribute("list", list);
		
		//view페이지로 이동
		request.getRequestDispatcher("view/listAll.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지별 리스트 출력
		request.setCharacterEncoding("UTF-8");
		
		//요청시 전송 데이터 받기 - page받기
		int page = Integer.parseInt(request.getParameter("page"));	//1뒤에 공백이 있거나 할 경우 : numberformatexception이 발생한다.
		String stype = request.getParameter("stype");	//최초 실행시에는 값이 없다.
		String sword = request.getParameter("sword");	//최초 실행시에는 값이 없다.
		
		
		//servlet객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//servlet 메소드 호출하기 pageInfo(page, stype, sword) - 결과값 받기 - PageVO
		PageVO vo = service.pageInfo(page, stype, sword);
		
		//service의 메소드 - selectByPage
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		
		List<BoardVO> list = service.selectByPage(map);
		
		//결과 값을 request에 저장
		request.setAttribute("list", list);
		request.setAttribute("PageVO", vo);
		
		//view페이지로 이동
		request.getRequestDispatcher("view/listPage.jsp").forward(request, response);
	}

}
