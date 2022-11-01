package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {

	//아이디 중복 검사
	public String selectById(String id);
	
	//우편번호 찾기
	public List<ZipVO> selectByDong(String dong);
	
	//저장하기 - 가입하기
	public String insertMember(MemberVO vo);
	
	//저장하기 - update를 이용한 insert => insert를 수행한 개수만큼 int로 출력
	public int insertUpdate(MemberVO vo);
	
	// 시도 찾기
	public List<String> selectSido();
	
	//군 찾기
	public List<String> selectGugun(String sido);
	
	//동찾기
	public List<String> selectDongName(Map<String, String> paramMap);
	
	public List<ZipVO> selectZip(Map<String, String> paramMap);
}
