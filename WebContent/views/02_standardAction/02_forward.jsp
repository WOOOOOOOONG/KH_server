<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello</h1>
	<script>alert("hello");</script>
	<!-- 포워딩 전에 응답 객체에 작성한 것(정확하게는 버퍼에 기록되어 있음)은
		forwarding 되면서 버퍼가 비워져서 아무 효과도 얻을 수 없다. -->
	
	<%-- <jsp:forward page="forwardPage.jsp"/> --%>
	<!-- 닫는 태그를 사용하거나 /로 마무리하기 -->
	<jsp:forward page="forwardPage.jsp">
		<jsp:param name="pName" value="Galaxy Note 10"/>
	</jsp:forward>
	<!-- 포워딩 되는 페이지에 파라미터 값을 전달할 수 있음 -->
	
	<!-- 예를 들어서 전달값의 결과에 따라 다른 JSP 페이지로 요청 처리를 전달할 때 사용할 수 있음
		전달하는 페이지에 내부적으로 request, response 객체가 같이 전달되며 url은 변경되지 않음 -->
</body>
</html>