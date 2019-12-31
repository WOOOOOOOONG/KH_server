package Member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static template.JDBCTemplate.*;

public class BoardDao {
	public BoardDao insertBoard(Connection conn, BoardDao board) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "INSERT INTO BOARD(BOARD_NUM, BOARD_WRITER, BOARD_TITLE, "
				+ "BOARD_CONTENT, BOARD_ORIGINAL_FILENAME, BOARD_RENAME_FILENAME, "
				+ "BOARD_REF, BOARD_REPLY_REF, BOARD_REPLY_LEV, BOARD_REPLY_SEQ, "
				+ "BOARD_READCOUNT, BOARD_DATE) VALUES(?, ?, ?, ?, NULL, ?, DEFAULT, DEFAULT"
				+ ", DEFAULT, DEFAULT, DEFAULT, DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getbNum());
			pstmt.setString(2, board.getbWriter());
			pstmt.setString(3, board.getbTitle());
			pstmt.setString(4, board.getbContent());
			pstmt.setString(5, board.getfileName());
			
			rset = pstmt.executeQuery();
			Board b = new Board(rset.getInt(1), rset.getString(2), rset.getString(3)
					, rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7),
					rset.getInt(8), rset.getInt(9), rset.getInt(10), rset.getInt(11), 
					rset.getDate(12));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
}
