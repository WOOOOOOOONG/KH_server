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
	<!-- application �������� ��� ������ contextPath ���� ���� -->
	<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application"/>
	<h1 align="center">�α���</h1>
	<form action="${ contextPath }/login" method="post" align="center">
		<label>���̵� : </label><input type="text" name="userId">
		<label>��й�ȣ : </label><input type="password" name="userPwd">
		<button type="submit">�α���</button>
	</form>
</body>
</html>