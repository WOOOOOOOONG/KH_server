package com.kh.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsAjaxServlet1
 */
@WebServlet("/jsAjax1.do")
public class JsAjaxServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsAjaxServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// Servlet에서 직접 응답화면 출력 시
		// 출력할 화면에 대한 mime type과 문자 인코딩을 지정해주어야 했다.
		response.setContentType("text/html; charset=UTF-8");
		
		// ajax는 이미 mime type이 지정되어진 화면에서
		// 응답할 문자만 전달하므로 문자에 대해서만 인코딩 처리를 진행하면 된다.
		
		// 응답 문자 인코딩 처리
		response.setCharacterEncoding("UTF-8");
		
		// 응답 데이터 전송 스트림 연결
		PrintWriter out = response.getWriter();
		
		out.append("서버에서 전송한 값<br>");
		out.append("name = " + name + ", age=" + age);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
