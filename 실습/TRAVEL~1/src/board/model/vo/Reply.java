package board.model.vo;

import java.sql.Date;

public class Reply {
	
	private int rId;
	private String rContent;
	private int refbId;
	private int rWriter;
	private String userName;
	private Date createDate;
	private Date modifyDate;
	private String status;
	public Reply(int rId, String rContent, int refbId, int rWriter, String userName, Date createDate, Date modifyDate,
			String status) {
		super();
		this.rId = rId;
		this.rContent = rContent;
		this.refbId = refbId;
		this.rWriter = rWriter;
		this.userName = userName;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public int getRefbId() {
		return refbId;
	}
	public void setRefbId(int refbId) {
		this.refbId = refbId;
	}
	public int getrWriter() {
		return rWriter;
	}
	public void setrWriter(int rWriter) {
		this.rWriter = rWriter;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reply [rId=" + rId + ", rContent=" + rContent + ", refbId=" + refbId + ", rWriter=" + rWriter
				+ ", userName=" + userName + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}
	
	

}
