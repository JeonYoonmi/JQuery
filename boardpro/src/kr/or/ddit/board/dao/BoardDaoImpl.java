package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {

	private SqlMapClient client;
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IBoardDao getInstence() {
		if(dao==null) dao = new BoardDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		
		return client.queryForList("board.selectAll");
	}

	public List<BoardVO> selectByPage(Map<String, Object> map) throws SQLException {
		
		return client.queryForList("board.selectByPage", map);
	}

	@Override
	public int searchCount(Map<String, Object> map) throws SQLException {
		
		return (int) client.queryForObject("board.searchCount", map);
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		
		return	(int) client.insert("board.insertBoard", vo);
	}

	@Override
	public int deleteBoard(int num) throws SQLException {
		
		return client.delete("board.deleteBoard", num);
	}

	@Override
	public int modifyBoard(BoardVO vo) throws SQLException {
		
		return client.update("board.modifyBoard", vo);
	}

	@Override
	public int updateHit(int num) throws SQLException {
		
		return client.update("board.updateHit", num);
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		
		return (int) client.insert("reply.insertReply", vo);
	}

	@Override
	public List<ReplyVO> listReply(int bonum) throws SQLException {
		
		return client.queryForList("reply.listReply", bonum);
	}

	@Override
	public int deleteReply(int renum) throws SQLException {
		
		return client.delete("reply.deleteReply", renum);
	}

	@Override
	public int updateReply(ReplyVO vo) throws SQLException {
		
		return client.update("reply.updateReply", vo);
	}


}
