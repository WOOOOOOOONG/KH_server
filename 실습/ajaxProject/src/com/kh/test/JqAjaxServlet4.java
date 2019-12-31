package com.kh.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.model.vo.User;

/**
 * Servlet implementation class a
 */
@WebServlet(name = "JqAjaxServlet4", urlPatterns = { "/jqAjax4.do" })
public class JqAjaxServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxServlet4() {
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
		
		// 요청받은 회원의 번호 저장
		int input = Integer.parseInt(request.getParameter("input"));
		
		/* 보통 Ajax 서버 통신시 데이터 전송을 위한 포맷을 XML이나 JSON을 많이 사용한다,
		 * 모두 플랫폼에 구애받지 않는 데이터 전송 포맷이다.
		 * 
		 * XML : 태그를 이용하여 작성하기 간편하고, 사람도 읽기 쉽다.
		 * 		 DTD(Document Type Definition)를 통한 확정이 쉽다.
		 * 		  태그 등의 반복으로 실제 데이터 외적으로 용량이 커지기 쉽고, 파싱하는데 무거워지는 단점이 있다.
		 * 
		 * json : 객체{} 또는 배열[]로 데이터를 효율적으로 표시하므로 XML 대비 용량이 적고 속도가 빠르다.
		 * 		  하지만 데이터 무결성을 개발자가 직접 검증해야하는 단점이 있다.
		 * 
		 * ** json(JavaScript Object Notation : 자바스크립트 객체 표기법) ***
		 * - json을 사용하여 모든 데이터형을 서버와 주고받을 수 있다.
		 *   (숫자, 문자열, boolean, 배열, 객체, null)
		 * - '{'로 시작하여 '}'로 끝나고 그 속에 데이터를 표기하는데 'key:value' 쌍으로 구성된다.
		 * - key는 문자열로 표현하므로 반드시 쌍따옴표를 해야하고, value는 기본자료형이나 문자열, 배열, 객체가 들어간다.
		 * 		(단, value로는 char형은 안됨 !!)
		 * - 순서는 의미없고, 오로지 'key:value'로 올바르게 매핑만 되어있으면 된다.
		 * 
		 * 가장 먼저 자바, JSP, 서블릿, 스프링에서 JSON을 사용한 데이터 전송을 하려면
		 * JSON 데이터 포맷을 위한 라이브러리가 필요하다.
		 * >> 라이브러리 추가
		 * 1. http://json.org/ 로 접속해서 json-simple 클릭
		 * 2. https://github.com/fangyidong/json-simple 밑에 please visit 누르기
		 * 3. https://code.google.com/archive/p/json-simple/downloads 클릭 후 1.1.1 버전 선택
		 * */
		
		User findUser = null;
		JSONObject jsonUser = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNo() == input) {
				findUser = list.get(i);
				
				jsonUser = new JSONObject(); // JSONObject 객체 생성
				jsonUser.put("no", findUser.getNo());
				jsonUser.put("name", findUser.getName());
				jsonUser.put("age", findUser.getAge());
				jsonUser.put("gender", findUser.getGender() + "");
				// -> value char형은 안되기 떄문에 문자열로 변환해준 것.
			}
		}
		//브라우저로 json 객체 전송
		// mime type, 문자 인코딩 설정
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		// out.print(findUser);
		// 자바 객체를 자바스크립트에서 쓰도록 할 수 없으므로 포맷을 변경해서 전달해주어야 함.
		// --> JSON
		
		// 1) toJSONString()
		// System.out.println("toJSONString : " + jsonUser.toJSONString());
		// 2) toString()
		// System.out.println("toString : " + jsonUser.toString());
		
		// 위의 두 메소드의 실행 결과는 동일하다.
		// toString 메소드는 결국 다시 toJSONString 메소드를 호출하기 때문이다.
		// 하지만 조회 회원이 없을경우 즉, userObj가 null일 경우는
		// NullPointerException이 발생한다.
		
		// 따라서 조회 회원이 없을 경우를 대비해서 toJSONString과 toString 메소드를 지양
		// 3) print, println 매개변수에 참조 변수명만 작성
		// System.out.println("jsonUser : " + jsonUser);
		
		out.print(jsonUser);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
