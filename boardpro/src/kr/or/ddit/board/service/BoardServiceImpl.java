package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService {

	private IBoardDao dao;
	private static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstence();
	}
	
	public static IBoardService getInstance() {
		if(service==null) service = new BoardServiceImpl();
		
		return service;
	}
	
	private int count;
	
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = null;
		
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		List<BoardVO> list = null;
		try {
			list = dao.selectByPage(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int searchCount(Map<String, Object> map) {
		count = 0;
		try {
			count = dao.searchCount(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int totalPage(String stype, String sword) {
		//전체 글 갯수 구하기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		
		count = this.searchCount(map);
		System.out.println("전체 글 갯수 : " + count);
		
		//전체 페이지 수 구하기
		int totalPage = (int) Math.ceil((double)count / PageVO.getPerList());
		System.out.println("전체 페이지 갯수 : " + totalPage);
		
		return totalPage;
	}
	
	@Override
	public PageVO pageInfo(int page, String stype, String sword) {
		//전체 페이지 수
		int totalPage = this.totalPage(stype, sword);
		
		//map - stype, sword, - 초기 실행시에는 값 없다. - map에 추가
		//start, end - map에 추가
		//page가 1 -> 1, 4
		//page가 2 -> 5, 8
		int start = (page-1) * PageVO.getPerList() + 1;
		int end = start + PageVO.getPerList() - 1;
		if(end > count) end = count;
		
		//시작 페이지 끝 페이지
		int perPage = PageVO.getPerPage();
		
		int startPage = ((page-1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage;

		PageVO vo = new PageVO();
		vo.setStart(start);
		vo.setEnd(end);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotalPage(totalPage);
		
		return vo;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int count = 0;
		try {
			count = dao.insertBoard(vo);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteBoard(int num) {
		int count = 0;
		try {
			count = dao.deleteBoard(num);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int modifyBoard(BoardVO vo) {
		int count = 0;
		try {
			count = dao.modifyBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateHit(int num) {
		int count = 0;
		try {
			count = dao.updateHit(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		int num = 0;
		try {
			num = dao.insertReply(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		List<ReplyVO> list = null;
		try {
			list = dao.listReply(bonum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteReply(int renum) {
		int count = 0;
		try {
			count = dao.deleteReply(renum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		int count = 0;
		try {
			count = dao.updateReply(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
