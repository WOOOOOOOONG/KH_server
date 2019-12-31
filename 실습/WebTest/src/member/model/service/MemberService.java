package member.model.service;

import static template.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public Member updateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMember = null;
		if(result > 0) {
			String userId = m.getUserId();
			updateMember = new MemberDao().selectMember(conn, userId);
			
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMember;
	}

}
