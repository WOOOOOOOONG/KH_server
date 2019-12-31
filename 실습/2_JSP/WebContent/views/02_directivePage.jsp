<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<String> list = new ArrayList<String>();
		// 지시어 page 속성 중 import를 통해 선언
		
		list.add("HTML");
		list.add("Servlet");
		list.add("JSP");
		
		Date today = new Date();
		
		// 오류 일부러 발생시키기
		list.add(10, "오류날껄");
		// 404에러 : 경로 문제
		// 500에러 : 코드상의 문제
	%>
	
	<p>리스트 길이 : <%= list.size() %></p>
	<p>오늘 날짜 : <%= today %></p>
	
	<!-- ***에러 페이지 컨트롤 방법 ***
		1. page 지시자 errorPage를 이용한 방법 -> error.jsp 만들기
		2. web.xml에 error-page 태그를 등록하는 방법 -> 404error.jsp 만들기
	-->	
</body>
</html>