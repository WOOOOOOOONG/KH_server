package member.model.vo;

import java.util.Date;

public class MyPlan {
	private int pId;
	private String mId;
	private String pName;
	private Date date;
	private String startTime;
	private String endTime;
	private String content;
	
	public MyPlan() {}
	
	public MyPlan(int pId, String mId, String pName, Date date, String startTime, String endTime, String content) {
		super();
		this.pId = pId;
		this.mId = mId;
		this.pName = pName;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.content = content;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MyPlan [pId=" + pId + ", mId=" + mId + ", pName=" + pName + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", content=" + content + "]";
	}

	
	
}
