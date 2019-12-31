package com.kh.model;

import java.sql.Connection;

public class BoardService {

	public int updateBoard(String name, String title, String writer, String content) {
		Connection conn = getConnection();
		
		int result = new BoardDao().updateBoard(conn, name, title, writer, content); 
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

}
