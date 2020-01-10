<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.model.vo.Person"%>
<%
	// 1. request, session 객체에 저장 된 속성 scriptlet 이용하여 화면 출력
	/* String classRoom = (String)request.getAttribute("classRoom");
	Person student = (Person)request.getAttribute("student");
	
	String academy = (String)session.getAttribute("academy");
	Person teacher = (Person)session.getAttribute("teacher"); */
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h3>1. 기존에 하던 방식으로 scriptlet을 이용하여 각 객체에 담겨 있는 값 화면 출력</h3>
	학원명 : <%= academy %> <br>
	강의장 : <%= classRoom %> <br>
	강사 : <%= teacher.getName() %>, <%= teacher.getAge() %>, <%= teacher.getGender() %>
	<br><br>
	수강생 정보
	<ul>
		<li>이름 : <%= student.getName() %></li>
		<li>나이 : <%= student.getAge() %></li>
		<li>성별 : <%= student.getGender() %></li>
	</ul> --%>

	<hr>
	
	<h3>2. EL을 이용하여 request, session 객체에 저장 된 속성 화면 출력하기</h3>
	<!-- EL은 Scriptlet과 다르게 getter를 사용하지 않고 변수명을 통해 직접 접근 가능
		내부적으로 해당 객체의 getter를 자동적으로 활용하여 저장 된 값을 읽어옴
	 -->
	
	학원명 : ${ academy } <br>
	강의장 : ${ classRoom } <br>
	강사 : ${ teacher.name }, ${ teacher.age }, ${ teacher.gender }
	<br><br>
	수강생 정보
	<ul>
		<li>이름 : ${ student.name }</li>
		<li>나이 : ${ student.age }</li>
		<li>성별 : ${ student.gender }</li>
	</ul>
	<!-- 내부적으로 Person 클래스의 getter를 호출하고 있으므로 주석하면
		500 에러 발생하는 것 확인 할 수 있음!!! -->
	
	<hr>
	
	<h3>3. EL 사용 시 내장 객체에 저장 된 속성명이 같은 경우</h3>

	scope : ${ scope }
	
	<!-- EL은 page -> request -> session -> application 순으로 해당 속성을 찾는다! -->

	<h3>4. 특정 내장 객체에 저장 된 속성 다루기</h3>
	<%
		// pageScope에 담기
		pageContext.setAttribute("scope", "page영역");
	%>
	pageScope : ${ scope } 또는 ${ pageScope.scope }	<br>
	requestScope : ${ requestScope.scope }	<br>
	sessionScope : ${ sessionScope.scope }	<br>
	applicationScope : ${ applicationScope.scope }

	<!-- 
		여러 스코프에 동일한 속성을 기록했다면, 이름 충돌(naming conflict)에 주의하여
		명시적으로 스코프를 지정해야 한다.
	 -->
</body>
</html>