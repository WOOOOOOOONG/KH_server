package com.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class SelectNoticeServlet
 */
@WebServlet("/selectList.no")
public class SelectNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Notice> list = new ArrayList<Notice>();
		list.add(new Notice(1, "첫 번째 공지", "첫 번째 공지사항입니다.", "관리자"));
		list.add(new Notice(2, "두 번째 공지", "두 번째 공지사항입니다.", "관리자"));
		list.add(new Notice(3, "세 번째 공지", "세 번째 공지사항입니다.", "관리자"));
		list.add(new Notice(4, "네 번째 공지", "네 번째 공지사항입니다.", "관리자"));
		list.add(new Notice(5, "다섯 번째 공지", "다섯 번째 공지사항입니다.", "관리자"));
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/notice/noticeList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
