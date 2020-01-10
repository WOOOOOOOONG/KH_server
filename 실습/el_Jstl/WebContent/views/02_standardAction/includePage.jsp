<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%
	String year = String.format("%tY", new Date());

	String pName = request.getParameter("pName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	copyright&copy; 2005 - <%= year %> 이 웹페이지의 저작권은 KH정보교육원에 있습니다.<br>
	pName : <%= pName %> <br>
	
	
	
	
	
	
	

</body>
</html>