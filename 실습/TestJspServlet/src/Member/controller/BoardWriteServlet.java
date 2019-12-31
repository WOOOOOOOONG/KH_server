package Member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member.model.BoardService;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/binsert")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html, utf-8");

		String btitle = (String)request.getAttribute("btitle");
		String bwriter = (String)request.getAttribute("btitle");
		String upfile = (String)request.getAttribute("upfile");
		String bcontent = (String)request.getAttribute("bcontent");
		
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		String fileName = f.format(new Date());
		
		ArrayList<Board> blist = new ArrayList<Board>();
		Board board = new Board(btitle, bwriter, upfile, bcontent, fileName);
		int result = BoardService.insertBoard(board);
		blist.add(b);
		
		if(result >= 0) {
			request.setAttribute("blist", blist);
			request.getRequestDispatcher(request.getContextPath() + "/resources/board.upfile").forward(request, response);
		}else {
			request.setAttribute("message", "게시글 등록 실패!");
			request.getRequestDispatcher(request.getContextPath() + "views/common/error.jsp");
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
