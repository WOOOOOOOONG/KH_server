package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet2
 */
@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출");
		
		// POST 방식으로 넘겨받은 데이터가 영어나 숫자가 아닌 경우 인코딩 처리 필요
		request.setCharacterEncoding("UTF-8");
		// request 내의 파라미터 값은 기본적으로 ISO-8859-1로 인코딩되었다고 간주하기 때문
		// request에서 파라미터 값을 가져오기 전에 인코딩 설정을 하자~
		// + get방식에서 인코딩 설정이 필요없는 이유는 url에 값이 포함되어 전달되기 때문
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] foodArr = request.getParameterValues("food");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
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
		
		response.setContentType("text/html; charset=UTF-8");
		
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
		out.println("<h2>개인정보 결과(POST) 화면</h2>");
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
		
		// 결과 확인 시 한글이 깨지는 것을 확인할 수 있음.
		// POST 방식으로 보낼 경우 반드시 인코딩 설정 필요
		// request.getParameter("name") 보다 먼저 기술해야 함.
		
		// 결과에 따라 화면을 만들게 되면 자바 코드로 화면을 구성하는 것이 너무 불편하므로
		// 반대로 html 코드에 자바 코드를 사용할 수 있는 jsp를 사용해서 화면을 구현하자!
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출");
		
		doGet(request, response);
	}

}
