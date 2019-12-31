package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.dao.PlanDao;
import member.model.vo.Member;
import member.model.vo.MyPlan;

public class PlanService {

	// 계획 추가
	public int insertPlan(MyPlan myplan) {
		Connection conn = getConnection();

		int result = new PlanDao().insertPlan(conn, myplan);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	// 계획 변경
	public MyPlan updatePlan(MyPlan mp) {
		Connection conn = getConnection();
		MyPlan updatePlan = null;

		int result = new PlanDao().updatePlan(conn, mp);

		if (result > 0) {
			updatePlan = new PlanDao().selectPlan(conn, mp.getpId());
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return updatePlan;
	}

	// 계획 삭제
	public int deletePlan(int pId, String mId) {
		Connection conn = getConnection();

		int result = new PlanDao().deletePlan(conn, pId, mId);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

}
