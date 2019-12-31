package board.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.vo.Attachment;
import board.model.vo.Board;

public class BoardDao {

	public int getListCount(Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Board> selectBList(Connection con, int currentPage, int boardLimit) {
		// TODO Auto-generated method stub
		return new ArrayList<Board>();
	}

	public Board selectBoard(Connection con, int bid) {
		// TODO Auto-generated method stub
		return new Board();
	}

	public Board selectBoardNoCnt(Connection con, int bid) {
		// TODO Auto-generated method stub
		return new Board();
	}

	public int deleteBoard(Connection con, int bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertBoard(Connection con, Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateBoard(Connection con, Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList selectFList(Connection con, int flag) {
		// TODO Auto-generated method stub
		return new ArrayList();
	}

	public int insertThumbnail(Connection con, Board b, ArrayList<Attachment> fileList) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Attachment> selectThumbnail(Connection con, int bId) {
		// TODO Auto-generated method stub
		return new ArrayList<Attachment>();
	}

	public ArrayList<Attachment> selectReplyList(Connection con, int bId) {
		// TODO Auto-generated method stub
		return null;
	}

}
