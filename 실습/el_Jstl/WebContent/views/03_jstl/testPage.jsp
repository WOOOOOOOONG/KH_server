<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	상품명 : ${ param.pName } <br>
	상품갯수 : ${ param.pCount } <br>
	옵션1 : ${ paramValues.option[0] } <br>
	옵션2 : ${ paramValues.option[1] } 
 
</body>
</html>