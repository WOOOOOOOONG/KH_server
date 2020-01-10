<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">${ sessionScope.loginUser.userName }님 환영합니다.</h3>
	
	<button onclick="location.href='${ contextPath }/views/member/myPage.jsp'">내정보 확인하기</button>
	<button onclick="location.href='${ contextPath }/selectList.no'">공지사항 확인하기</button>
	
	
</body>
</html>