<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		el 안에서
		param : 전달 된 파라미터 값을 받아올 때 사용<br>
		paramValues : 전달 된 파라미터들을 배열로 받아올 때 사용
	</p>
	
	<h2>주문내역</h2>
	상품명 : ${ param.pname } <br>
	수량 : ${ param.pcount } <br>
	옵션1 : ${ paramValues.option[0] } <br>
	옵션2 : ${ paramValues.option[1] } <br>
	<!-- 값이 두 개 이상 이지만 param 내장 객체를 통해서도 접근이 가능함
		하지만 첫번째 값만 가져올 수 있음 -->
	옵션 : ${ param.option }
</body>
</html>