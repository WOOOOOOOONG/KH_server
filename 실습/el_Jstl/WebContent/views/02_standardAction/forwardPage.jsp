<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>여기는 forwardPage입니다.</h2>
	pName : ${ param.pName }
	
	<h2>참고 : jsp:useBean 활용하기</h2>
	
	<!-- com.kh.model.vo.Person 클래스를 참조하여 page 범위에 m이라는 이름의 빈 객체 선언 -->
	<jsp:useBean id="m" class="com.kh.model.vo.Person" scope="page"/>
	
	<!-- setter를 이용한 값 저장 -->
	<jsp:setProperty name="m" property="name" value="우별림"/>
	<jsp:setProperty name="m" property="age" value="20"/>
	<jsp:setProperty name="m" property="gender" value="F"/>
	
	<!-- getter를 이용한 값 조회 -->
	이름 : <jsp:getProperty property="name" name="m"/>
	나이 : <jsp:getProperty property="age" name="m"/>
	성별 : <jsp:getProperty property="gender" name="m"/>
	

</body>
</html>