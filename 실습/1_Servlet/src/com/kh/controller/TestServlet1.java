package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/test1")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 첫번째 파라미터인 HttpServletRequest request는 웹 브라우저에서 사용자가 요청한 내용을 받아주는 용도로 사용
		// 두번째 파라미터인 HttpServletResponse response는 첫번째 파라미터에서 처리한 결과를 웹 브라우저에서 사용자에게 보여주기 위한 용도로 사용
		
		// 사용자가 보낸 정보를 받아내기 위한 메소드
		// request.getParameter("name속성값") --> 해당 value값(무조건 String으로) 리턴
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		
		// 체크박스 등 복수의 정보를 받을 때는 name값을 기준으로 배열로 받아야 한다.
		// request.getParameterValues("name속성값") --> 해당 values값들 배열(String 배열)에 담아서 리턴
		String[] foodArr = request.getParameterValues("food");
		
		// 사용자가 요청을 통해 전달한 값을 변수에 담아 출력
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		
		// 값이 입력되지 않고 넘어오면 null이 넘어옴
		// 체크박스 체크하지 않고 넘겼을  경우 nullPointerException 방지를 위해
		if(foodArr != null) {
			for(int i = 0; i < foodArr.length; i++) {
				System.out.println("foodArr[" + i + "] : " + foodArr[i]);
			}
		}
		
		// 해당 요청에 대한 처리를 다 마치고 결과를 받았다는 가정하에(DB로 데이터 보내는 과정 생략)
		// 결과에 맞춰서 해당 결과 화면을 출력해주어야 하므로 response 객체 사용
		
		// 응답 화면에 대한 설정
		// 문서 형태는 html이고 문자 셋은 utf-8이라는 것을 지정
		// 이 과정이 없으면 인코딩 문제로 형식이 깨지게 됨
		response.setContentType("text/html; charset=UTF-8");
		
		// 사용자에게 응답화면을 출력하기 위한 스트림(클라이언트와의 길)을 생성
		// response 객체의 문자 기반 출력 스트림
		PrintWriter out = response.getWriter();
		
		// 자바 코드를 통해 응답화면 작성
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인정보출력화면</title>");
		out.println("<style>");
		out.println("h2{color:red;}");
		out.println("span.name{color:orange; font-weight:bold;}");
		out.println("span.gender{color:yellow; font-weight:bold;}");
		out.println("span.age{color:green; font-weight:bold;}");
		out.println("span.city{color:blue; font-weight:bold;}");
		out.println("span.height{color:navy; font-weight:bold;}");
		out.println("span.food{color:purple; font-weight:bold;}");
		out.println("</style");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인정보 결과(GET) 화면</h2>");
		out.printf("<span class='name'>%s</span>님은 ", name);
		out.printf("<span class='age'>%s</span>이시며 ", age);
		out.printf("<span class='city'>%s</span>에 사는 ", city);
		out.printf("<span class='height'>%scm의 </span> ", height);
		out.printf("<span class='gender'>%s</span>입니다. ", gender);
		out.print("좋아하는 음식은 <span class='food'>");
		
		// 반복문(Servlet이 자바 언어이기 떄문에 반복문으로 화면 구현 가능)
		if(foodArr != null) {
			for(int i = 0; i < foodArr.length; i++) {
				out.printf("%s ", foodArr[i]);
			}
			out.println("</span>입니다. ");
		}else {
			out.println("</span>없습니다.");
		}
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
