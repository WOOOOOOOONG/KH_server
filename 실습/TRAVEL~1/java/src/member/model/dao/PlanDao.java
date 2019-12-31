package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.MyPlan;

public class PlanDao {
	private Properties prop = new Properties();

	public PlanDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 계획 넣기 
	public int insertPlan(Connection conn, MyPlan mp) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertPlan");

		// int pId, String mId, String pName, Date date, String startTime, String endTime
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mp.getpId());
			pstmt.setString(2, mp.getmId());
			pstmt.setString(3, mp.getpName());
			pstmt.setDate(4, (java.sql.Date) mp.getDate());
			pstmt.setString(5, mp.getStartTime());
			pstmt.setString(6, mp.getEndTime());
			pstmt.setString(7, mp.getContent());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 계획 조회 
	public MyPlan selectPlan(Connection conn, int getpId) {
		MyPlan mp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPlan");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getpId);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				mp = new MyPlan(rset.getInt("pId"), rset.getString("m_Id"), rset.getString("p_name"),
						rset.getDate("date"), rset.getString("starttitme"), rset.getString("endtime"), rset.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mp;
	}

	// 계획 삭제 
	public int deletePlan(Connection conn, int pId, String mId) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deletePlan");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pId);
			pstmt.setString(2, mId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	// 계획 수정 
	public int updatePlan(Connection conn, MyPlan mp) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePlan");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mp.getpName());
			pstmt.setDate(2, (Date) mp.getDate());
			pstmt.setString(3, mp.getStartTime());
			pstmt.setString(4, mp.getEndTime());
			pstmt.setString(5, mp.getContent());
			pstmt.setInt(6, mp.getpId());
			pstmt.setString(7, mp.getmId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	

}
