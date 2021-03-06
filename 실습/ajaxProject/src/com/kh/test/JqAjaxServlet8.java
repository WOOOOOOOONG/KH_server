package com.kh.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.kh.model.vo.User;

/**
 * Servlet implementation class JqAjaxServlet8
 */
@WebServlet("/jqAjax8.do")
public class JqAjaxServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxServlet8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list = new ArrayList<>();
		
		list.add(new User(1, "김영희", 30, '여'));
		list.add(new User(2, "김철수", 28, '남'));
		list.add(new User(3, "오영심", 26, '여'));
		list.add(new User(4, "홍길동", 24, '남'));
		list.add(new User(5, "한영희", 22, '여'));
		int id = Integer.parseInt(request.getParameter("id"));

		User findUser = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNo() == id) {
				findUser = list.get(i);
			}
		}
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(findUser, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
