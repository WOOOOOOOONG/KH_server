package member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import QA.model.vo.QA;
import board.model.dao.BoardDao;
import static common.JDBCTemplate.*;

public class QADao {
	private Properties prop = new Properties();
	public QADao() {
		String fileName = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	// 내가 문의한 내역 리스트
	public ArrayList<QA> selectQAList(Connection conn, String mId) {
		ArrayList<QA> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectQAList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new QA(rset.getString("QA_TYPE"),
								rset.getString("QA_TITLE"),
								rset.getString("QA_STATUS"),
								rset.getDate("ENROLL_DATE")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	// 전체 회원이 문의한 내역 리스트(m_id로 m_name 조인해서 가져옴)
	public ArrayList<QA> selectAllQAList(Connection conn) {
		ArrayList<QA> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectAllQAList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new QA(rset.getString("QA_TYPE"),
								rset.getString("QA_TITLE"),
								rset.getString("QA_STATUS"),
								rset.getDate("ENROLL_DATE"),
								rset.getString("M_NAME")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// 문의하기
	public int insertQuestion(Connection conn, QA q) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertQuestion");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, q.getqType());
			pstmt.setString(2, q.getqTitle());
			pstmt.setString(3, q.getqContent());
			pstmt.setString(4, q.getmId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 문의 삭제하기
	public int deleteQuestion(Connection conn, int qId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteQuestion");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, qId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 문의 수정하기
	public int updateQuestion(Connection conn, QA q) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateQuestion");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, q.getqType());
			pstmt.setString(2, q.getqTitle());
			pstmt.setString(3, q.getqContent());
			pstmt.setString(4, q.getmId());
			pstmt.setInt(5, q.getqId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 문의 상세 내역
	public QA selectQA(Connection conn, int qId) {
		QA q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectAllQAList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				q = new QA(rset.getString("QA_TYPE"),
								rset.getString("QA_TITLE"),
								rset.getString("QA_CONTENT"),
								rset.getString("QA_STATUS"),
								rset.getDate("ENROLL_DATE"),
								rset.getString("ANSWER"),
								rset.getDate("AN_DATE"),
								rset.getString("M_NAME"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return q;
	}
	
	// 쿼리문 update로 answer 컬럼 content 값으로 수정(답변 수정할때도 이 메소드씀)
	public int insertAnswer(Connection conn, int qId, String answer) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAnswer");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, qId);
			pstmt.setString(2, answer);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	//쿼리문 update로 answer 컬럼 null값으로 수정
	public int deleteAnswer(Connection conn, int qId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteAnswer");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, qId);
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
