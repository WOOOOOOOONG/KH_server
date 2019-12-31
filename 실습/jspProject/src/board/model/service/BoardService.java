package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.Reply;

import static common.JDBCTemplate.*;

public class BoardService {

	// 1. 게시글 리스트 갯수 조회용 서비스 메소드
	public int getListCount() {
		Connection conn = getConnection();

		int listCount = new BoardDao().getListCount(conn);

		close(conn);

		return listCount;
	}

	// 2. 게시글 리스트 조회용 서비스 메소드
	public ArrayList<Board> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectList(conn, currentPage, boardLimit);

		close(conn);

		return list;
	}

	// 3. 게시판 상세보기(조회수 증가)
	public Board selectBoard(int bid) {
		Connection conn = getConnection();

		// BoardDao 메소드 두개를 호출하기 때문에 그냥 참조변수로 선언하자
		BoardDao bDao = new BoardDao();

		// 따라서 게시판 상세보기용 서비스에서는 조회수 증가하는 기능 또한 구현해야된다.
		int result = bDao.increaseCount(conn, bid);

		Board b = null;

		if (result > 0) {
			commit(conn);
			b = bDao.selectBoard(conn, bid);
		} else {
			rollback(conn);
		}

		close(conn);

		return b;
	}

	// 4. 게시판 상세보기(조회수 증가 없이)
	public Board selectBoardNoCnt(int bid) {
		Connection conn = getConnection();

		Board b = new BoardDao().selectBoard(conn, bid);

		close(conn);

		return b;
	}

	// 5. 게시글 삭제 서비스
	public int deleteBoard(int bid) {
		Connection conn = getConnection();

		int result = new BoardDao().deleteBoard(conn, bid);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
	
	// 6. 게시글 입력용 서비스
	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	// 7. 게시글 수정 서비스
	public int updateBoard(Board board) {
		Connection conn = getConnection();

		int result = new BoardDao().updateBoard(conn, board);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	// 사진 게시판 리스트에 보여질 게시판 리스트 조회용 서비스
	// 전달 받은 flag 값이 1인 경우 게시판 정보 리스트가 리턴
	// 2인 경우 메인 사진 리스트가 리턴
	public ArrayList selectList(int flag) {
		Connection conn = getConnection();
		
		ArrayList list = null;
		
		BoardDao bDao = new BoardDao();
		
		if(flag == 1) {
			list = bDao.selectBList(conn);
		}else {
			list = bDao.selectFList(conn);
		}
		
		close(conn);
		
		return list;
	}

	// 사진 게시판 글쓰기
	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		
		int result1 = bDao.insertThBoard(conn, b);
		int result2 = bDao.insertAttachment(conn, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}
	
	// 사진 게시판 상세보기 
	public ArrayList<Attachment> selectThumbnail(int bId) {
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new BoardDao().selectThumbnail(conn, bId);
		
		close(conn);
		
		return list;
	}
	
	// 첨부파일 다운로드 수 증가, 파일 다운로드용 서비스
	public Attachment selectAttachment(int fid) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		
		// 1. 첨부파일 다운로드 수 증가
		int result = bDao.updateDownloadCount(conn, fid);
		
		Attachment at = null;
		// 첨부파일 다운로드 수가 잘 증가하면
		if(result > 0) {
			commit(conn);
			// 2. 첨부파일 셀렉해오기 -> originName, changeName, filePath
			at = bDao.selectAttachment(conn, fid);			
		}else {
			rollback(conn);
		}
		
		close(conn);
		return at;
	}

	// 선택한 게시글의 댓글 리스트 조회용 서비스
	public ArrayList<Reply> selectReplyList(int bId) {
		Connection conn = getConnection();
		
		ArrayList<Reply> rlist = new BoardDao().selectReplyList(conn, bId);
		
		close(conn);
		
		return rlist;
	}

	// 댓글 추가 시 새로 갱신된 댓글 리스트 조회용 서비스
	public ArrayList<Reply> insertReply(Reply r) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		
		int result = bDao.insertReply(conn, r);
		
		ArrayList<Reply> rlist = null;
		
		if(result > 0) {
			commit(conn);
			rlist = bDao.selectReplyList(conn, r.getRefBid());
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return rlist;
	}

}
