package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.Reply;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/detail.bo")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bId = Integer.parseInt(request.getParameter("bId"));
		Board board = null;
		
		/*	세션 : 관련 자원을 모두 서버에서 관리
		 *  쿠키 : 쿠키 생성만 서버에서 관여하고 관리는 브라우저에서 관리.
		 *  	 (쿠키의 최대 값은 5kb)
		 *  
		 *  순서
		 *  1) detail.bo 호출시마다 해당 bId가 cookies에 존재하는지 확인하여 존재하지 않는다면
		 *     쿠키 키는 "bId"+bId 값, 쿠키 값은 bId 값으로하여
		 *     response 객체에 addCookie 메소드를 통해 쿠키 객체를 추가하고 조회수 증가 + 셀렉함
		 *  2) 이 응답에 실린 쿠키를 이제 브라우저가 관리함
		 *  3) 다음 요청 때 이 쿠키를 함께 전송함
		 *  4) detail.bo 호출시마다 해당 bId가 cookies에 존재하는지 확인하여 존재한다면
		 *     조회수 증가 없이 셀렉함
		 *  
		 * 위 방식으로 조회수 반복 증가를 막아줌
		 * */
		
		boolean isGet = false;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				// 1. bId 쿠키가 있는 경우
				if(c.getName().equals("bId"+bId)) {
					isGet = true;
				}
			}
			
			// 2. bId 쿠키가 없는 경우
			if(!isGet) {
				// 조회수 증가 및 셀렉
				board = new BoardService().selectBoard(bId);
				Cookie c1 = new Cookie("bId"+bId, String.valueOf(bId));
				c1.setMaxAge(1 * 24 * 60 * 60); // 하루동안 저장
				response.addCookie(c1);
			}else {
				// 조회수 증가하지 않고 셀렉
				board = new BoardService().selectBoardNoCnt(bId);
			}
			
		}
		
		
		// ajax를 이용한 댓글 기능 구현
		ArrayList<Reply> rlist = new BoardService().selectReplyList(bId);
		
		if(board != null) {
			request.setAttribute("board", board);
			// ajax 이후
			request.setAttribute("rlist", rlist);
			request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "게시판 상세조회에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
