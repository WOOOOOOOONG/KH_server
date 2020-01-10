package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.Reply;

public class BoardService {

	// 1. 게시글 리스트 갯수 조회용 서비스 메소드
	public int getListCount() {
		Connection con = getConnection();
		int result = new BoardDao().getListCount(con);
		
		return 0;
	}

	// 2. 게시글 리스트 조회용 서비스 메소드
	public ArrayList<Board> selectList(int currentPage, int boardLimit) {
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().selectBList(con,currentPage,boardLimit);
		
		return new ArrayList<Board>();

	}

	// 3. 게시판 상세보기(조회수 증가)
	public Board selectBoard(int bid) {
		Connection con = getConnection();
		Board b = new BoardDao().selectBoard(con , bid);
		return new Board();
	}

	// 4. 게시판 상세보기(조회수 증가 없이)
	public Board selectBoardNoCnt(int bid) {
		Connection con = getConnection();
		Board b = new BoardDao().selectBoardNoCnt(con , bid);
		return new Board();
	}

	// 5. 게시글 삭제 서비스
	public int deleteBoard(int bid) {
		Connection con = getConnection();
		int result = new BoardDao().deleteBoard(con,bid);
		return 0;
	}

	// 6. 게시글 입력용 서비스
	public int insertBoard(Board b) {
		Connection con = getConnection();
		int result = new BoardDao().insertBoard(con,b);
		return 0;
	}

	// 7. 게시글 수정 서비스
	public int updateBoard(Board b) {

		Connection con = getConnection();
		int result = new BoardDao().updateBoard(con,b);
		return 0;
	}

	// 사진 게시판 리스트에 보여질 게시판 리스트 조회용 서비스
	// 전달 받은 flag 값이 1인 경우 게시판 정보 리스트가 리턴
	// 2인 경우 메인 사진 리스트가 리턴
	public ArrayList selectList(int flag) {
		Connection con = getConnection();
		ArrayList list = new BoardDao().selectFList(con,flag);
		return new ArrayList();
	}

	// 사진 게시판 글쓰기
	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = new BoardDao().insertThumbnail(con,b,fileList);
		return 0;
	}

	// 사진 게시판 상세보기
	public ArrayList<Attachment> selectThumbnail(int bId) {
		Connection con = getConnection();
		ArrayList<Attachment> list = new BoardDao().selectThumbnail(con,bId);
		return new ArrayList<Attachment>();
	}
	
	public ArrayList<Reply> selectReplyList(int bId){
		Connection con = getConnection();
		ArrayList<Attachment> list = new BoardDao().selectReplyList(con,bId);
		
		return new ArrayList<Reply>();
		
		
	}

}
