package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Person;

/**
 * Servlet implementation class ElServlet
 */
@WebServlet("/el.do")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSP 내장 객체 범위
		// 1. page : 현재 해당 페이지에서만 사용 가능 --> 공유 범위 가장 작음
		// 2. request : 요청받고 응답 페이지에서까지 사용 가능 --> 공유 범위가 다음으로 큼(하지만 제한적)
		// 3. session : 한 브라우저 당 1개 존재하므로 모든 jsp에서 사용 가능 --> 공유 범위는 모든 jsp
		// 4. application : 한 애플리케이션마다 1개 존재하므로 애플리케이션 전역에서 사용 가능 --> 공유 범위 가장 큼
		
		// 위의 4개의 객체 영역에 데이터를 담을 때는 setAttribute, 꺼낼 때는 getAttribute
		
		// requestScope에 담기
		request.setAttribute("classRoom", "L강의장");
		request.setAttribute("student", new Person("홍길동", 23, '남'));
		
		// sessionScope에 담기
		HttpSession session = request.getSession();
		
		session.setAttribute("academy", "KH정보교육원");
		session.setAttribute("teacher", new Person("우별림", 20, '여'));
		
		// request, session, application 영역에 같은 속성명으로 값을 담기
		request.setAttribute("scope", "request영역");
		session.setAttribute("scope", "session영역");
		
		ServletContext application = request.getServletContext();
		application.setAttribute("scope", "application영역");
		
		
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("views/01_EL/01_el.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
