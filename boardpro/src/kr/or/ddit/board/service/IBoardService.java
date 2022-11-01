package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	
	//리스트 출력
	public List<BoardVO> selectAll();
	
	//페이지별 리스트
	public List<BoardVO> selectByPage(Map<String, Object> map);
	
	//전체 글 개수 구하기
	public int searchCount(Map<String, Object> map);
	
	//전체 페이지수 구하기
	public int totalPage(String stype, String sword);
	
	//페이지별 정보 구하기
	public PageVO pageInfo(int page, String stype, String sword);
	
	//글쓰기
	public int insertBoard(BoardVO vo);
	
	//삭제
	public int deleteBoard(int num);
	
	//수정
	public int modifyBoard(BoardVO vo);
	
	//조회수 증가
	public int updateHit(int num);
	
	//댓글 저장
	public int insertReply(ReplyVO vo);
	
	//댓글 리스트
	public List<ReplyVO> listReply(int bonum);
	
	//댓글 수정
	public int updateReply(ReplyVO vo);
	
	//댓글 삭제
	public int deleteReply(int renum);
	
}
