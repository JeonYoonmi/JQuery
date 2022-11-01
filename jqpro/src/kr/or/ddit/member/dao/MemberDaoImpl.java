package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

/*
	SqlMapClient객체 -
	자신의 class객체를 생성해서 리턴한다.
*/

public class MemberDaoImpl implements IMemberDao {
	private SqlMapClient client;
	private static 	MemberDaoImpl dao;
	
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IMemberDao getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public String selectById(String id) throws SQLException {
		/*
		String resid = null;
		
		resid = (String) client.queryForObject("member.selectById", id);
		
		return resid;
		*/
		
		return (String) client.queryForObject("member.selectById", id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) throws SQLException {
		List<ZipVO> list = null;
		
		list = client.queryForList("zip.selectByDong", dong);
		
		return list;
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (String) client.insert("member.insertMember", vo);
	}

	@Override
	public int insertUpdate(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return client.update("member.insertUpdate", vo);
	}

	@Override
	public List<String> selectSido() throws SQLException {
		List<String> list = client.queryForList("zip.selectSido");
		return list;
	}

	@Override
	public List<String> selectGugun(String sido) throws SQLException {
		List<String> list = client.queryForList("zip.selectGugun", sido);
		return list;
	}

	@Override
	public List<String> selectDongName(Map<String, String> paramMap) throws SQLException {
		List<String> list = client.queryForList("zip.selectDongName", paramMap);
		return list;
	}

	@Override
	public List<ZipVO> selectZip(Map<String, String> paramMap) throws SQLException {
		List<ZipVO> list = client.queryForList("zip.selectZip", paramMap);
		return list;
	}

}
