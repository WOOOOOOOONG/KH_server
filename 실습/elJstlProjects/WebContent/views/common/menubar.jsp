<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">${ sessionScope.loginUser.userName }�� ȯ���մϴ�.</h3>
	
	<button onclick="location.href='${ contextPath }/views/member/myPage.jsp'">������ Ȯ���ϱ�</button>
	<button onclick="location.href='${ contextPath }/selectList.no'">�������� Ȯ���ϱ�</button>
	
	
</body>
</html>