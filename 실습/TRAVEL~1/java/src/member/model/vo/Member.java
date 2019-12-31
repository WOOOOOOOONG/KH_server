package member.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class Member {
	private String userId;
	private String userNo;
	private String userPwd;
	private String userName;
	private String nickName;
	private String phone;
	private String email;
	private Date joinDate;
	private String status;
	private String bArray;
	
	public Member() {}

	public Member(String userId, String userNo, String userPwd, String userName, String nickName, String phone,
			String email, Date joinDate, String status, String bArray) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickName = nickName;
		this.phone = phone;
		this.email = email;
		this.joinDate = joinDate;
		this.status = status;
		this.bArray = bArray;
	}
	
	public Member(String userId, String userNo, String userPwd, String userName, String nickName, String phone,
			String email, String status, String bArray) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickName = nickName;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.bArray = bArray;
	}

	public Member(String userId, String nickName) {
		super();
		this.userId = userId;
		this.nickName = nickName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getbArray() {
		return bArray;
	}

	public void setbArray(String bArray) {
		this.bArray = bArray;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", nickName=" + nickName + ", phone=" + phone + ", email=" + email + ", joinDate=" + joinDate
				+ ", status=" + status + ", bArray=" + bArray + "]";
	}
}
