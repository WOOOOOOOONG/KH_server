<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test Function Page</h1>
	
	<c:set var="str" value="How are you?"/>
	
	str : ${ str } <br>
	모두 대문자로 출력 : ${ fn:toUpperCase(str) } <br>
	모두 소문자로 출력 : ${ fn:toLowerCase(str) } <br>
	문자열의 길이 : ${ fn:length(str) } <br>
	
	<c:set var="idx1" value="${ fn:indexOf(str, 'are') }"/>
	<c:set var="idx2" value="${ fn:indexOf(str, 'you?') }"/>
	idx1에서 idx2 전까지 : ${ fn:substring(str, idx1, idx2) } <br>
	'are' 이후 : ${ fn:substringAfter(str, 'are') } <br>
	'are' 이전 : ${ fn:substringBefore(str, 'are') } <br>
	
	are -> were 변경 : ${ fn:replace(str, 'are', 'were') } <br>
	replace 후 str : ${ str } <br>
	
	<c:set var="arr" value="${ fn:split(str, ' ') }"/>
	<c:forEach var="s" items="${ arr }">
		split 결과 출력 : ${ s } <br>
	</c:forEach>
	
	join 결과 출력 : ${ fn:join(arr, ' ') } <br>
	
	<c:if test="${ fn:startsWith(str, 'H') }">
		문자열이 H로 시작
	</c:if><br>
	<c:if test="${ fn:endsWith(str, '?') }">
		문자열이 ?로 끝남
	</c:if><br>
	<c:if test="${ fn:contains(str, 'are') }">
		문자열에 are 포함
	</c:if><br>
	<c:if test="${ fn:containsIgnoreCase(str, 'ARE') }">
		문자열에 대소문자 무관하게 ARE 포함
	</c:if><br>
	
	
	
	
	
	
	
	
	
	






</body>
</html>