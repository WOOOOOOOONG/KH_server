<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.model.vo.Person, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<p>
		Expression Language(표현 언어)라고 하며<br>
		&lt;%= value %&gt;, out.print(value)와 같이 JSP 화면에 표현하고자 하는 <br>
		코드를 \${ value }의 형식으로 표현하여 작성하는 것
	</p>
	
	<ul>
		<li><a href="el.do">01_EL이란?</a></li>
		<li><a href="views/01_EL/02_elParam.jsp">02_EL-param</a></li>
		<li><a href="views/01_EL/03_elOperation.jsp">03_EL-opation</a></li>
		<li><a href="">04_EL-object: PDF 참조</a>
	</ul>
	
	<hr>
	<!-- 
		* JSP를 이루는 구성인자
		1. 스크립팅 원소 : JSP 페이지에서 자바 코드를 직접 기술할 수 있게 하는 기능
			ex) 스크립틀릿, 표현식(출력식) 등
		2. 지시어 : JSP 페이지 정보에 대한 내용을 표현한다거나 다른 jsp 페이지를 포함할 때 사용
			아직 사용하지 않았지만 JSP의 기능을 확장시키는 라이브러리를 등록할 때도 사용
		3. JSP 액션 태그(표준 액션 태그, 커스텀 액션 태그)
		
		* JSP 액션
		1. 표준 액션 (Standard option) : JSP 페이지에서 바로 사용 가능
									표준 액션은 모든 태그의 이름 앞에 jsp라는 접두어가 붙음
		2. 커스텀 액션(Custom action) : 별도의 라이브러리를 설치해야만 사용 가능
								인터넷에서 다운받아 사용 가능할 뿐만 아니라 사용자가 직접 만들어서도 가능
								커스텀 액션은 모든 태그의 이름 앞에 jsp 외의 접두어가 붙음
								
	 -->
	 <h1>JSP Action Tag</h1>
	 <p>
	 	JSP Action 태그는 XML 기술을 이용하여 기존의 JSP 문법을 확장하는 매커니즘을 <br>
	 	제공하는 태그로, 웹 브라우저에서 실행되는 것이 아니라, 웹 컨테이너에서 실행되고<br>
	 	결과만 브라우저로 보냄
	 </p>
	 
	 <h3>1. 표준 액션(Standard action)</h3>
	 <a href="views/02_standardAction/01_include.jsp">01_include</a>
	 <a href="views/02_standardAction/02_forward.jsp">02_forward</a>
	 
		
</body>
</html>