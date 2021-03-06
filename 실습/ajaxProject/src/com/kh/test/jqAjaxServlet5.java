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
 * Servlet implementation class jqAjaxServlet5
 */
@WebServlet("/jqAjax5.do")
public class jqAjaxServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jqAjaxServlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 연습용 데이터
				// 사용자 정보가 저장되어 있는 List 생성(DB에 다음과 같은 회원들이 있다고 생각)
				ArrayList<User> list = new ArrayList<>();
				
				list.add(new User(1, "김영희", 30, '여'));
				list.add(new User(2, "김철수", 28, '남'));
				list.add(new User(3, "오영심", 26, '여'));
				list.add(new User(4, "홍길동", 24, '남'));
				list.add(new User(5, "한영희", 22, '여'));
				
				// 요청 받은 성별
				char gender = request.getParameter("gender").charAt(0);
				
				// JSONArray : JSONObject를 배열 형태로 나타내어 인덱스별로 나누어 저장할 수 있는 객체   
				// [{"k":v,"k":v",...}, {"k":v,"k":v",...}, {"k":v,"k":v",...}, ...]
				
				// JSONArray 생성
				JSONArray jArr = new JSONArray();
				
				// 선택한 성별을 가진 회원의 정보를 담아 JSONArray에 추가한 JSONObject 생성
				
				// 선택한 성별을 회원이 정보를 담아 JSONArray에 추가할 JSONObejct 생성
				JSONObject jsonUser = null;
				
				for(User user : list){ 
					if(user.getGender() == gender) {
						jsonUser = new JSONObject();
						jsonUser.put("no", user.getNo());
						jsonUser.put("name", user.getName());
						jsonUser.put("age", user.getAge());
						jsonUser.put("gender", user.getGender() + ""); // character 안됨
						
						// JSONObejct를 JSONArray에 추가
						jArr.add(jsonUser);
					}
				}
				
				// mime type 설정, 문자 인코딩 설정
				// mime : Multipurpose Internet Mail Extensions
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().print(jArr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
