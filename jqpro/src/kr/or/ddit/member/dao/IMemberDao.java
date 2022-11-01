package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {

	//아이디 중복 검사
		public String selectById(String id) throws SQLException;
		
		//우편번호 찾기
		public List<ZipVO> selectByDong(String dong) throws SQLException;
		
		//저장하기 - 가입하기
		public String insertMember(MemberVO vo) throws SQLException;
		
		//저장하기 - update를 이용한 insert => insert를 수행한 개수만큼 int로 출력
		public int insertUpdate(MemberVO vo) throws SQLException;
		
		// 시도 찾기
		public List<String> selectSido() throws SQLException;
		
		//군 찾기
		public List<String> selectGugun(String sido) throws SQLException;
		
		//동찾기
		public List<String> selectDongName(Map<String, String> paramMap) throws SQLException;
		
		public List<ZipVO> selectZip(Map<String, String> paramMap) throws SQLException;
		
}
