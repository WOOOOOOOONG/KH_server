package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import java.util.ArrayList;

import member.model.dao.MemberDao;

import member.model.vo.Member;

public class MemberService {

	private MemberDao mdao = new MemberDao();

	public MemberService() {
	}

	public Member loginCheck(String userId, String userPwd) {

		Connection conn = getConnection();

		Member loginMember = mdao.loginCheck(conn, userId, userPwd);

		close(conn);

		return loginMember;

	}

	public ArrayList<Member> selectAll() {

		Connection conn = getConnection();

		ArrayList<Member> list = mdao.selectList(conn);

		close(conn);

		return list;

	}

	public Member selectOne(String userId) {

		Connection conn = getConnection();

		Member member = mdao.selectOne(conn, userId);

		close(conn);

		return member;

	}

	public int insertMember(Member member) {

		Connection conn = getConnection();

		int result = mdao.insertMember(conn, member);

		if (result > 0)

			commit(conn);

		else

			rollback(conn);

		close(conn);

		return result;

	}

	public int updateMember(Member member) {

		Connection conn = getConnection();

		int result = mdao.updateMember(conn, member);

		if (result > 0)

			commit(conn);

		else

			rollback(conn);

		close(conn);

		return result;

	}

	public int deleteMember(String userId) {

		Connection conn = getConnection();

		int result = mdao.deleteMember(conn, userId);

		if (result > 0)

			commit(conn);

		else

			rollback(conn);

		close(conn);

		return result;

	}

}
