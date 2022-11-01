package kr.or.ddit.board.vo;

public class PageVO {
	
	private int start;				//현재페이지 내에서 시작 글번호
	private int end;				//현재페이지 내에서 끝 글번호
	
	private int startPage;			//브라우저에 출력되는 시작페이지
	private int endPage;			//브라우저에 출력되는 끝페이지
	private int totalPage;			//전체 페이지 수
	private int count;				//db에 저장된 전체 글 갯수 - 검색 키워드에 따라 달라진다.
	
	private static int perList = 5;	// 한페이지에 출력되는 글 갯수
	private static int perPage = 3;	// 전체 페이지 갯수
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static int getPerList() {
		return perList;
	}
	public static void setPerList(int perList) {
		PageVO.perList = perList;
	}
	public static int getPerPage() {
		return perPage;
	}
	public static void setPerPage(int perPage) {
		PageVO.perPage = perPage;
	}
	
}
