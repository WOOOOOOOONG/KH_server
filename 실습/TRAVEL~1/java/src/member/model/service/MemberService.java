package member.model.service;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

public class MemberService {

	// 로그인 
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();

		Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);

		close(conn);

		return loginUser;
	}

	// 멤버 추가
	public int insertMember(Member m) {
		Connection conn = getConnection();

		int result = new MemberDao().insertMember(conn, m);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
	
	// 멤버 확인
	public int idCheck(String userId) {
		Connection conn = getConnection();
		int result = new MemberDao().idCheck(conn, userId);
		
		close(conn);
		
		return result;
	}
	
	// 멤버 정보 변경 
	public Member updateMember(Member m) {
		Connection conn = getConnection();
		Member updateMember = null;
		
		int result = new MemberDao().updateMember(conn, m);
		
		if(result > 0) {
			updateMember = new MemberDao().selectMember(conn, m.getUserId());
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMember;
	}
	
	// 멤버 비밀번호 변경
	public Member updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		Member updateMember = null;
		int result = new MemberDao().updatePwd(conn, userId, userPwd, newPwd);
		if(result > 0) {
			updateMember = new MemberDao().selectMember(conn, userId);
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return updateMember;
	}
	
	// 6. 회원 탈퇴용 서비스
	public int deleteMember(String userId) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
