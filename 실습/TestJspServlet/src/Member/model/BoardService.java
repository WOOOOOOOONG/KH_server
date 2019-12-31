package Member.model;

import java.sql.Connection;
import static template.JDBCTemplate.*;

public class BoardService {
	public Board insertBoard(Board board) {
		Connection conn = getConnection();
		
		Board b = new BoardDao.insertBoard(conn, board);
		
		if(b != null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return b;
	}
}
