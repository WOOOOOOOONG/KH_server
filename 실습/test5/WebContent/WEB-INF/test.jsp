<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러 발생 : 로그인 실패</h1>
	
	<p onclick="href='<%= request.getContextPath() %>/index.jsp';">홈으로</p>
	<br>
	<p onclick="href='location.back()';">이전 페이지로 이동</p>
</body>
</html>