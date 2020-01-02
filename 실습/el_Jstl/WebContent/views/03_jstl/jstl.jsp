<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL이란?</h1>
	<p>
		JSP Standard Tag Library <br>
		JSP에서 사용하는 커스텀 태그로,공통으로 사용하는 코드의 집합을 사용하기 쉽게<br>
		태그화 하여 표준으로 제공하는 것을 말한다.
	</p>
	
	<h3>* 라이브러리 등록 후 사용 가능</h3>
	1) https://tomcat.apache.org/download-taglibs.cgi 접속<br>
	2) standard-1.2.5 -> jar files -> 4개 다 다운로드<br>
	3) WebContetnt/WEB-INF/lib에 추가<br>
	
	<hr>
	
	<h3>* JSTL 선언 방법</h3>
	<p>
		JSTL을 사용하고자 하는 JSP 페이지의 상단 page 지시자 아래에<br>
		taglib 지시자를 사용하여 선언해야함<br><br>
		
		&lt;%@ taglib prefix="사용하고자 하는 접두사" uri = "tld 파일상의 uri" %&gt;
		
		<br>
		prefix: 접두사. 다른 태그와 구별할 수 있는 name space를 제공함. <br>
		uri : 실제 웹 상의 주소가 아닌, 태그 라이브러리를 나타내는 식별자. <br>
				tld 파일 상에 uri값을 가리키며, 이 지시자를 통해 작성한 태그 이름과<br>
				매칭되는 자바 코드를 찾음.
		tld (Tag Library Descriptor) 파일 : 커스텀 태그 정보를 갖고 있는 라이브러리 파일
	</p>
	
	<hr>
	
	<h4>1. JSTL core Library</h4>
	변수와 url, 조건문, 반복문 등의 로직과 관련된 JSTL 문법을 제공<br><br>
	<a href="01_core.jsp">core</a>
	
	<h4>2. JSTL Formatting Library</h4>
	날짜, 시간, 숫자 데이터의 출력 형식을 지정할 때 사용하는 태그 <br><br>
	<a href="02_fmt.jsp">fmt</a>
	
	<h4>3. JSTL Functions Library</h4>
	문자열 처리에 관한 메소드들을 EL형식에서 사용할 수 있도록 제공 <br><br>
	<a href="03_fn.jsp">fn</a>
</body>
</html>