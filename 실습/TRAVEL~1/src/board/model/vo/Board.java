package board.model.vo;

import java.sql.Date;

public class Board {
	private int bId;	// 게시글 고유 번호
	private int bType;  // 게시글 타입(1. 여행 게시판, 2. 축제 게시판  3. 숙박게시판  4.커뮤니티)
	private String bTitle;	// 게시글 제목
	private String bContent; // 게시글 내용
	private String bWriter; // 게시글 작성자 이름
	private int bCount; 	// 게시글 조회수
	private int good;
	private int ngood;
	private Date wDate;
	private Date uDate;
	private String lCode;
	private String status; 	// 게시글 상태(Y, N)
	
	public Board() {}

	public Board(int bId, int bType, String bTitle, String bContent, String bWriter, int bCount, int good, int ngood,
			Date wDate, Date uDate, String lCode, String status) {
		super();
		this.bId = bId;
		this.bType = bType;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.bCount = bCount;
		this.good = good;
		this.ngood = ngood;
		this.wDate = wDate;
		this.uDate = uDate;
		this.lCode = lCode;
		this.status = status;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public int getbType() {
		return bType;
	}

	public void setbType(int bType) {
		this.bType = bType;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getNgood() {
		return ngood;
	}

	public void setNgood(int ngood) {
		this.ngood = ngood;
	}

	public Date getwDate() {
		return wDate;
	}

	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}

	public Date getuDate() {
		return uDate;
	}

	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}

	public String getlCode() {
		return lCode;
	}

	public void setlCode(String lCode) {
		this.lCode = lCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Board [bId=" + bId + ", bType=" + bType + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bWriter="
				+ bWriter + ", bCount=" + bCount + ", good=" + good + ", ngood=" + ngood + ", wDate=" + wDate
				+ ", uDate=" + uDate + ", lCode=" + lCode + ", status=" + status + "]";
	}
	
	

}



