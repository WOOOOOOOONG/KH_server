<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP World!</h1>
	<p>
		HTML 형식에서 자바 코드를 사용할 수 있는 "자바 언어"로<br>
		서블릿에서 JAVA 코드로 응답 HTML을 구현했던 복잡함을 간단하게 작성하고 해결할 수 있다.<br>
		--> JSP의 가장 큰 장점은 Servlet에서 비지니스 로직(java)과 프레젠테이션 로직(html)을<br>
		분리할 수 있다는 것이다.
	</p>
	<hr>
	<h1>JSP Elements 표현법</h1>
	<h2>1. JSP 스크립팅 원소(Scripting Element)</h2>
	<p>JSP 페이지에 자바 코드를 직접 기술할 수 있게 해주는 기능이다.</p>
	<ol>
		<li>선언문 : &lt;%! 자바코드 %&gt;
			멤버 변수와 메소드를 선언하기 위해 사용<br><br>
		</li>
		<li>스크립틀릿 : &lt;% 자바코드 %&gt;
			JSP에서 자바코드를 사용하기 위해 사용<br><br>
		</li>
		<li>표현식(출력식) : &lt;%= 자바코드 %&gt;
			자바에서 작성한 값을 출력하기 위해 사용<br><br>
		</li>
		<li><a href="views/01_sum.jsp">View details &raquo;</a></li>
	</ol>
	
	<hr>
	
	<h2>2. 지시어(Directive)</h2>
	<p>JSP page 전체에 영향을 미치는 정보를 기술할 때 쓰임</p>
	<ol>
		<li> page : 현재의 JSP 페에지를 컨테이너에서 처리하는데 필요한 각종 속성을
		         기술하는 부분으로 보통 소스의 맨 앞에 위치
		     <ul>
		     	<li>language : 사용할 스크립트 언어 유형을 지정</li>
		     	<li>contentType : 웹 브라우저가 받아 볼 페이지의 형식, 인코딩 방식 지정</li>
		     	<li>pageEncoding : JSP 파일에 기록 된 자바코드의 인코딩 방식을 지정</li>
		     	<li>import : 자바의 import와 같은 의미</li>
		     	<li>errorPage / isErrorPage : 오류 페이지 관리</li>
		     	<li><a href="views/02_directivePage.jsp">View details &raquo;</a></li>
		     </ul><br><br>    
		</li>
		<li> include : jsp 파일이 자바 파일로 바뀔 때 자바 문서에 삽입되어 컴파일 되는 파일 추가<br>
			<a href="views/03_directiveInclude.jsp">Views details &raquo;</a>
		</li>
		<li> taglib : JSP 기능을 좀 더 확장할 수 있는 인자로 정의된 사용자 정의 태그를 가져와 
		사용할 수 있는 방법 제공
		</li>
	</ol>
	<hr>
	
	<h2>피자 주문 페이지(jsp) -> 주문 버튼 클릭(submit) -> Servlet -> 피자 결제 페이지(jsp)</h2>
	<a href="views/04_pizzaOrderForm.jsp">피자 주문 페이지</a>
	
</body>
</html>