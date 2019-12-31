package member.model.dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao {

	public Member loginCheck(Connection conn, String userId, String userPwd) {
		Member mem = new Member();
		String sql = "SELECT * FROM memeber WHERE user_id = ? AND user_pwd = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				rset.next();
				mem.setUserId(rset.getString("user_id"));
				mem.setUserPwd(rset.getString("user_pwd"));
				mem.setUserName(rset.getString("user_name"));
				mem.setGender(rset.getString("gender"));
				mem.setAge(rset.getInt("age"));
				mem.setPhone(rset.getString("phone"));
				mem.setEmail(rset.getString("email"));
				mem.setHobby(rset.getString("hobby"));
				mem.setEtc(rset.getString("etc"));
				mem.setEnrollDate(rset.getDate("enroll_date"));
				mem.setLastModified(rset.getDate("last_modified"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return mem;
	}

	public ArrayList<Member> selectAll(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "SELECT * FROM memeber";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				Member mem = new Member();
				mem.setUserId(rset.getString("user_id"));
				mem.setUserPwd(rset.getString("user_pwd"));
				mem.setUserName(rset.getString("user_name"));
				mem.setGender(rset.getString("gender"));
				mem.setAge(rset.getInt("age"));
				mem.setPhone(rset.getString("phone"));
				mem.setEmail(rset.getString("email"));
				mem.setHobby(rset.getString("hobby"));
				mem.setEtc(rset.getString("etc"));
				mem.setEnrollDate(rset.getDate("enroll_date"));
				mem.setLastModified(rset.getDate("last_modified"));
				
				list.add(mem);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	public Member selectOne(Connection conn, String userId) {
		Member mem = new Member();
		String sql = "SELECT * FROM member WHERE user_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rset.next();
				
				mem.setUserId(rset.getString("user_id"));
				mem.setUserPwd(rset.getString("user_pwd"));
				mem.setUserName(rset.getString("user_name"));
				mem.setGender(rset.getString("gender"));
				mem.setAge(rset.getInt("age"));
				mem.setPhone(rset.getString("phone"));
				mem.setEmail(rset.getString("email"));
				mem.setHobby(rset.getString("hobby"));
				mem.setEtc(rset.getString("etc"));
				mem.setEnrollDate(rset.getDate("enroll_date"));
				mem.setLastModified(rset.getDate("last_modified"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return mem;
	}

	public int insertMember(Connection conn, Member member) {
		String sql = "INSERTO INTO member(user_id, user_pwd, user_name, gender, age, phone, email, hobby, etc, enroll_date, last_modified) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getHobby());
			pstmt.setString(9, member.getEtc());
			pstmt.setDate(10, member.getEnrollDate());
			pstmt.setDate(11, member.getLastModified());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection conn, Member member) {
		String sql = "UPDATE member SET ";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getHobby());
			pstmt.setString(9, member.getEtc());
			pstmt.setDate(10, member.getEnrollDate());
			pstmt.setDate(11, member.getLastModified());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		String sql = "DELETE FROM member WHERE user_id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
