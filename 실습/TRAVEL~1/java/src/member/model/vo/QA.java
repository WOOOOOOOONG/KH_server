package member.model.vo;

import java.util.Date;

public class QA {
	private int qId;
	private String qType;
	private String qTitle;
	private String qContent;
	private String status;
	private Date enrollDate;
	private String answer;
	private Date answerDate;
	private String mId;
	
	public QA() {}

	public QA(int qId, String qType, String qTitle, String qContent, String status, Date enrollDate, String answer,
			Date answerDate, String mId) {
		super();
		this.qId = qId;
		this.qType = qType;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.status = status;
		this.enrollDate = enrollDate;
		this.answer = answer;
		this.answerDate = answerDate;
		this.mId = mId;
	}
	
	

	public QA(String qType, String qTitle, String qContent, String status, Date enrollDate, String answer,
			Date answerDate, String mId) {
		super();
		this.qType = qType;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.status = status;
		this.enrollDate = enrollDate;
		this.answer = answer;
		this.answerDate = answerDate;
		this.mId = mId;
	}

	public QA(String qType, String qTitle, String status, Date enrollDate) {
		super();
		this.qType = qType;
		this.qTitle = qTitle;
		this.status = status;
		this.enrollDate = enrollDate;
	}
	
	

	public QA(String qType, String qTitle, String status, Date enrollDate, String mId) {
		super();
		this.qType = qType;
		this.qTitle = qTitle;
		this.status = status;
		this.enrollDate = enrollDate;
		this.mId = mId;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "QA [qId=" + qId + ", qType=" + qType + ", qTitle=" + qTitle + ", qContent=" + qContent + ", status="
				+ status + ", enrollDate=" + enrollDate + ", answer=" + answer + ", answerDate=" + answerDate
				+ ", mId=" + mId + "]";
	}
	
	
	
}
