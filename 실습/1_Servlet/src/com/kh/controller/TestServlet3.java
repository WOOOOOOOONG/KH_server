package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3
 */
@WebServlet("/test3")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글을 위한 인코딩 지정
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] foodArr = request.getParameterValues("food");
		
		// 위임 : 떠넘기다
		// jsp에게 html 코드를 작성할 수 있도록 위임
		// request 객체 속성에 변수 지정
		// void javax.servlet.ServletRequest.setAttribute(String key, Object value)
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		
		String foods = "";
		if(foodArr != null) {
			foods = String.join(", ", foodArr);
		}else {
			foods = "없음";
		}
		request.setAttribute("foods", foods);
		
		// 위임 객체 > RequestDispatcher 클래스
		
		// 뷰 선택
		RequestDispatcher view = request.getRequestDispatcher("views/testServlet3End.jsp");
		view.forward(request, response);
		
		/* RequestDispatcher : 현재 request에 담긴 정보를 저장하고 있다가
		 * 그 다음 페이지, 그 다음 페이지에도 해당 정보를 볼 수 있게 저장하는기능
		 * 
		 * forward 방식 : 기존 파라미터 정보를 유지하며 페이지 전환
		 * A.jsp -> Servlet -> B.jsp 일 때,
		 * A가 가지고 있는 파라미터 정보를 B로 넘겨줌
		 * request와 response 객체를 공유함
		 * Web Container 차원에서 페이지 이동만 있고,
		 * 실제로 웹 브라우저는 다른 페이지로 이동했음을 알 수 없어 웹 브라우저에는 최초에 호출한
		 * URL이 표시되고 이동한 페이지의 URL 정보는 볼 수 없음.
		 * */
		/*
		 * 별도로 sendRedirect 방식이 있는데
		 * 이는 모든 파라미터 정보를 제외하고 단순 페이지 호출만 하는 것.
		 * 새로운 페이지에서는 request와 response 객체가 새롭게 생성된다.
		 * 값을 가지고 가야 한다면 forward, 아니면 sendRedirect
		*/
//		response.sendRedirect("views/testServlet3End.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
