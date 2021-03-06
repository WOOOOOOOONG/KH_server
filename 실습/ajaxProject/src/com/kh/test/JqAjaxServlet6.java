package com.kh.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.model.vo.User;

/**
 * Servlet implementation class JqAjaxServlet6
 */
@WebServlet("/jqAjax6.do")
public class JqAjaxServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JqAjaxServlet6() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자 정보가 저장되어 있는 List 생성(DB에 다음과 같은 회원들이 있다고 생각)
		ArrayList<User> list = new ArrayList<>();

		list.add(new User(1, "김영희", 30, '여'));
		list.add(new User(2, "김철수", 28, '남'));
		list.add(new User(3, "오영심", 26, '여'));
		list.add(new User(4, "홍길동", 24, '남'));
		list.add(new User(5, "한영희", 22, '여'));

		// 요청으로 넘어온 파라미터 받기
		String keyword = request.getParameter("keyword");

		// JSONArray 생성
		JSONArray jArr = new JSONArray();

		// JSONObject 생성
		JSONObject jsonUser = null;
		for (User u : list) {
			if (u.getName().contains(keyword)) {
				jsonUser = new JSONObject();
				jsonUser.put("no", u.getNo());
				jsonUser.put("name", u.getName());
				jsonUser.put("age", u.getAge());
				jsonUser.put("gender", u.getGender() + "");

				jArr.add(jsonUser);
			}
		}

		// 만약에 jArr 즉, 검색된 회원들이 담겨있는 jArr 객체도 전달해주고 싶고,
		// 아까 요청으로 들어온 키워드도 다시 전달해주고 싶은 경우?
		// --> 응답할 데이터가 여러개인 경우에는 어떻게 처리할까 ?

		// 이런 경우 map의 형태로 다시 JSONObject에 담아서 보내주면 된다.
		JSONObject jsonMap = null;

		if (keyword != null && jArr != null) {
			jsonMap = new JSONObject();

			jsonMap.put("jArr", jArr);
			jsonMap.put("keyword", keyword);
		}

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonMap); // 사실상 JSONObject가 전달되는 것
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
