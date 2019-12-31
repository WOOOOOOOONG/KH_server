package member.model.service;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

public class MemberService {

	// 1. 로그인용 서비스
	public Member loginMember(String userId, String userPwd) {
		// JDBCTemplate 만들기
		Connection conn = getConnection();

		Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);

		close(conn);

		return loginUser;
	}

	// 2. 회원가입용 서비스
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
	// 3. 아이디 중복 체크용 서비스
	public int idCheck(String userId) {
		Connection conn = getConnection();
		int result = new MemberDao().idCheck(conn, userId);
		
		close(conn);
		
		return result;
	}
	
	// 4. 회원 정보 수정용 서비스
	public Member updateMember(Member m) {
		Connection conn = getConnection();
		Member updateMember = null;
		
		// 1. 수정사항 업데이트
		int result = new MemberDao().updateMember(conn, m);
		
		if(result > 0) {
			// 업데이트 성공 시
			updateMember = new MemberDao().selectMember(conn, m.getUserId());
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMember;
	}
	
	// 5. 비밀번호 변경용 서비스
	public Member updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		Member updateMember = null;
		// 1. 비밀번호 변경
		int result = new MemberDao().updatePwd(conn, userId, userPwd, newPwd);
		// 2. updateMember select 해오기
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
