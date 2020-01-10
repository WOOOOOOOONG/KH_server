package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
// @WebServlet("/login.me") --> 암호화 처리 전
@WebServlet(name="LoginServlet", urlPatterns="/login.me")
// --> 암호화 처리 후
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전송 값에 한글이 있을 경우 인코딩 처리
		// request.setCharacterEncoding("utf-8"); // 대소문자 상관 없음
		// 하지만 로그인의 경우 넘어오는 값에 한글이 없으므로 필요 없음
		
		// 2. 전송 값 꺼내서 변수에 기록하기 또는 객체에 저장하기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// Member Vo 클래스 만들러 가기~~~
		
		// 3. 비즈니스 로직 처리하는 서비스 클래스의 해당 메소드를 실행하고, 그 처리 결과를 받음
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		System.out.println(loginUser);
		
		// 4. 서비스 요청에 해당하는 결과를 가지고 성공/실패에 대한 뷰페이지(파일)을 선택해서 내보냄
		if(loginUser != null) {
			// 로그인 성공 화면
			// 이제 member를 어딘가에 담아서 보내줘야 하는데 다음과 같은 방식이 있음
			// 1. application : jsp, servlet, java 다 접근해서 사용 가능
			// --> 공유 범위가 가장 큼
			// 2. session : 로그인 한 그 사용자만 사용 할 수 있음. jsp에서 사용 가능
			// --> 공유 범위가 모든 jsp
			// 3. request : 전달 받은 그 대상 jsp만 꺼내 쓸 수 있음.
			// --> 공유 범위가 제한적임
			// 4. page(==this) : 자기 자신만 쓸 수 있음. 해당 jsp 파일 안에서만 사용 가능.
			// --> 공유 범위가 제일 작음
			
			// 위의 4개의 객체 모두 setAttribute(key, value)를 이용해 객체를 저장 할 수 있음
			// 꺼낼 때는 getAttribute(key)를 이용함
			// 삭제할 때는 removeAttribute(key)를 이용함
			
			// 해당 클라이언트에 대한 세션 객체 생성
			HttpSession session = request.getSession();
			
			// session.setMaxInactiveInterval(600);
			// 10분 뒤 자동 로그아웃 기능
			// (마지막 접근 이후 일정 시간 이내에 다시 세션에 접근하지 않을 경우
			//  자동 세션 종료)
			
			session.setAttribute("loginUser", loginUser);
			// 세션 객체에 로그인한 유저의 정보를 담음
			// 세션 객체에 정보를 저장했기 때문에 request에 담을 필요X
			
			// 로그인 완료 후 다시 메인 페이지로
			response.sendRedirect(request.getContextPath());
			
		}else {
			// 로그인 실패 화면
			request.setAttribute("msg", "로그인에 실패하였습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			// common - errorPage.jsp 만들기~~
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
