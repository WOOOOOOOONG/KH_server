<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이 페이지의 언어는 java 언어다.
	contentType은 html이고 인코딩은 UTF-8이다. -->	
<% // <% 스크립틀릿이라고 해서 이 안에서 java코드를 쓸 수 있다
	// 서블릿에서 이쪽으로 떠넘기기 위해 request 객체에 setAttribute로 값을 담아줌
	// 담은 값을 뽑아올 때는 getAttribute()
	String name = (String)request.getAttribute("name");
	String age = (String)request.getAttribute("age");
	String city = (String)request.getAttribute("city");
	String height = (String)request.getAttribute("height");
	String gender = (String)request.getAttribute("gender");
	String food = (String)request.getAttribute("foods");
	// 페이지 로딩과 동시에 값을 가져오기 위해 보통 위쪽에서 작업함.
%>
<!-- 
	getParameter
		클라이언트의 HTML 페이지에서 필요한 정보를 얻는데 사용
		웹 브라우저에서 전송받은 request 영역에서 name 값이 같은 것을 찾아 값을 읽어옴.
		항상 String 반환
	
	getAttribute
		이전에 다른 jsp 또는 Servlet 페이지에 설정된 매개변수를 가져오는데 사용
		request.setAttribute에서 설정을 해준 값을 가져오며 설정이 없으면 무조건 null
 -->
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
	h2{color:red;}
	span.name{color:orange; font-weight:bold;}
	span.gender{color:yellow; font-weight:bold;}
	span.age{color:green; font-weight:bold;}
	span.city{color:blue; font-weight:bold;}
	span.height{color:navy; font-weight:bold;}
	span.food{color:purple; font-weight:bold;}
</style>
</head>
<body>
	<h2>개인 취향 테스트 결과(Servlet+JSP)</h2>
	<span class="name"><%= name %></span> 님은
	<span class="age"><%= age %></span>이시며,
	<span class="city"><%= city %></span>에 사는
	키 <span class="height"><%= height %></span>cm인
	<span class="gender"><%= gender %></span>입니다.
	좋아하는 음식은<span class="food"><%= food %></span>입니다.
	
</body>
</html>