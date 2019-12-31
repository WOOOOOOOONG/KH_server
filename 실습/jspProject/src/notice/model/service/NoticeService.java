package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import static common.JDBCTemplate.*;

public class NoticeService {

	// 1. 공지사항 리스트 조회용 서비스
	public ArrayList<Notice> selectList() {
		Connection conn = getConnection();

		ArrayList<Notice> list = new NoticeDao().selectList(conn);

		close(conn);

		return list;
	}

	// 2. 공지사항 글 작성용 서비스
	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDao().insertNotice(conn, n);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	// 3. 공지사항 상세보기 서비스
	public Notice selectNotice(int nno) {
		Connection conn = getConnection();
		
		// 1. 조회수 증가
		int result = new NoticeDao().increaseCount(conn, nno);
		
		Notice n = null;
		if(result > 0) {
			// 2. 공지사항 글 조회
			n = new NoticeDao().selectNotice(conn, nno);
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);

		return n;
	}
	
	// 조회수 증가 없이 공지사항 선택(수정용)
	public Notice selectNotice2(int nno) {
		Connection conn = getConnection();
		Notice n = new NoticeDao().selectNotice(conn, nno);
		close(conn);
		return n;
	}

	public int updateNotice(Notice n) {
		Connection conn = getConnection();

		int result = new NoticeDao().updateNotice(conn, n);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int deleteNotice(int nno) {
		Connection conn = getConnection();

		int result = new NoticeDao().deleteNotice(conn, nno);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public ArrayList<Notice> selectList(String search, String searchCondition) {
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectList(conn, search, searchCondition);

		close(conn);

		return list;
	}
}
