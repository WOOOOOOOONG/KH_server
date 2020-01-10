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
		list.add(new Notice(1, "ù ��° ����", "ù ��° ���������Դϴ�.", "������"));
		list.add(new Notice(2, "�� ��° ����", "�� ��° ���������Դϴ�.", "������"));
		list.add(new Notice(3, "�� ��° ����", "�� ��° ���������Դϴ�.", "������"));
		list.add(new Notice(4, "�� ��° ����", "�� ��° ���������Դϴ�.", "������"));
		list.add(new Notice(5, "�ټ� ��° ����", "�ټ� ��° ���������Դϴ�.", "������"));
		
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
