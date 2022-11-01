package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service==null) service = new MemberServiceImpl();
		
		return service;
	}
	
	
	@Override
	public String selectById(String id) {
		String sid = null;
		
		try {
			sid = dao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sid;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		List<ZipVO> list = null;
		
		try {
			list = dao.selectByDong(dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String insertMember(MemberVO vo) {
		String id = null;
		
		try {
			id = dao.insertMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public int insertUpdate(MemberVO vo) {
		int res = 0;
		
		try {
			res = dao.insertUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<String> selectSido(){
		List<String> list = null;
		try {
			list = dao.selectSido();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> selectGugun(String sido){
		List<String> list = null;
		try {
			list = dao.selectGugun(sido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> selectDongName(Map<String, String> paramMap){
		List<String> list = null;
		try {
			list = dao.selectDongName(paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ZipVO> selectZip(Map<String, String> paramMap) {
		List<ZipVO> list = null;
		
		try {
			list = dao.selectZip(paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
