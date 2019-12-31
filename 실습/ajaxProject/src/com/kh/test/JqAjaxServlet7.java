package com.kh.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.model.vo.User;

/**
 * Servlet implementation class JqAjaxServlet7
 */
@WebServlet("/jqAjax7.do")
public class JqAjaxServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxServlet7() {
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
		
		/* Gson : Goole JSON을 뜻함
		 * 자바 List와 Map같은 컬렉션을 아주 쉽게 json 객체로 전송할 수 있다.
		 * 자바 오브젝트의 직렬화, 역직렬화를 해주는 오픈소스 자바 라이브러리
		 * 
		 * >> Gson을 사용하기에 앞서 라이브러리 가져오기
		 * http://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.5
		*/
		
		response.setContentType("application/json; charset=utf-8");
		// 응답할 객체, 응답할 스트림
		new Gson().toJson(list, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
