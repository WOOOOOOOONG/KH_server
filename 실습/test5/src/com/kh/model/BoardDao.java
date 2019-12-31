package com.kh.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDao {

	public int updateBoard(Connection conn, String name, String title, String writer, String content) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET NAME = ?, TITLE = ?, WRITER = ?, CONTENT = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, writer);
			pstmt.setString(4, content);
			
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
