<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- application 전역에서 사용 가능한 contextPath 변수 선언 -->
	<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application"/>
	<h1 align="center">로그인</h1>
	<form action="${ contextPath }/login" method="post" align="center">
		<label>아이디 : </label><input type="text" name="userId">
		<label>비밀번호 : </label><input type="password" name="userPwd">
		<button type="submit">로그인</button>
	</form>
</body>
</html>