<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>include</h3>
	<p>다른 페이즈를 포함하고자 할 때 쓰이는 방식</p>
	
	<div>
		<h3>신간소개</h3>
		도서명 : 자바의 정석 <br>
		저자 : 남궁성 <br>
		가격 : 30,000원
	</div>
	<hr>
	
	<%-- <p>
		<h4>1) include 지시어(정적 include 방식)</h4>
		
		&lt;%@ include file="경로" %&gt; <br>
		-> 부모 JSP 파일이 컴파일 되기 전에 페이지에 삽입되어짐.<br><br>
		
		특징 : include된 페이지에서 scriptlet으로 선언된 변수를 그대로 사용할 수 있음<br>
		<%@ include file="includePage.jsp" %> <br><br>
		
		include된 페이지의 year : <%= year %> <br><br>
		
		문제점 : 현재 페이지와 include한 페이지의 변수명 중복이 일어남(유지보수가 불편함)
		<% String year = String.format("%tY", new Date()); %>
		<!-- 같은 이름으로 변수선언 시 Duplicate local variable year 발생 -->
	</p> --%>
	
	<p>
		<h4>2) JSP Action Tag include (동적 include 방식)</h4>
		
		&lt;jsp:include page="경로" /&gt; <br>
		-> 부모 JSP 파일이 화면에 출력되는 시점(런타임)에 삽입되어짐<br><br>
		<!-- 포함될 문서의 서블릿이 별도로 만들어짐 -->
		
		특징1 : include된 페이지와 변수를 공유하지 않아 유지보수에 편리함<br><br>
		<jsp:include page="includePage.jsp"/><br>
		<!-- 닫는 태그를 사용하거나 /로 닫아주기 -->
		<% String year = String.format("%tY", new Date()); %>
		<!-- 중복되는 변수명으로 선언해도 에러가 발생하지 않음 -->
		<br><br>
		
		특징2 : Scripting include와 반대로 include된 페이지로 값을 전달할 수 있음<br><br>
		<jsp:include page="includePage.jsp">
			<jsp:param name="pName" value="Galaxy Note 10"/>
		</jsp:include>
	</p>
</body>
</html>