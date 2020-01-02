<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test Format Page</h1>
	
	<h3>1. formatNumber</h3>
	<pre>
	숫자의 데이터 포맷 지정
	- 표현하고자 하는 숫자의 형색을 통화 기호, %등 원하는 쓰임에 맞게 지정하는 태그
	</pre>
	
	<!-- groupingUsed 속성 : 숫자 단위의 구분자(,) 표시 여부 지정 -->
	숫자 그대로 출력 : <fmt:formatNumber value="123456789" groupingUsed="false"/><br>
	세자리마다 구분하여 출력 : <fmt:formatNumber value="123456789" groupingUsed="true"/><br>
	
	<!-- pattern 속성 : 화면에 표시할 데이터의 스타일을 지정
					소수점 아래 자릿수를 지정 : #, 0 기호를 사용하여 지정 -->
	# : <fmt:formatNumber value="1.23" pattern="#.###"/> <br>
	0 : <fmt:formatNumber value="1.23" pattern="0.000"/> <br>
	
	<!-- type 속성 : 백분율(%), 통화 기호 지정
					number(일반 숫자), percent(백분율), currency(통화) -->
	percent : <fmt:formatNumber value="0.75" type="percent"/> <br>
	currency : <fmt:formatNumber value="50000" type="currency"/> <br>
	currency : <fmt:formatNumber value="50000" type="currency" currencySymbol="$"/> <br>
	
	<h3>2. formatDate</h3>
	<pre>
	날짜와 시간에 데이터 포맷 형식 지정
	value 속성에는 java.util.Date 객체를 사용해야 함
	</pre>
	
	<fmt:formatDate value="<%= new java.util.Date() %>"/>
	<c:set var="current" value="<%= new java.util.Date() %>"/>
	
	<ul>
		<li>오늘 날짜 : <fmt:formatDate value="${ current }" type="date"/></li>
		<li>현재 시간 날짜 : <fmt:formatDate value="${ current }" type="time"/></li>
		<li>둘 다 : <fmt:formatDate value="${ current }" type="both"/></li>
		<li>[Full] : <fmt:formatDate value="${ current }" type="both" dateStyle="full" timeStyle="full"/></li>
		<li>[Long] : <fmt:formatDate value="${ current }" type="both" dateStyle="long" timeStyle="long"/></li>
		<li>[Medium] : <fmt:formatDate value="${ current }" type="both" dateStyle="medium" timeStyle="medium"/></li>
		<li>[Short] : <fmt:formatDate value="${ current }" type="both" dateStyle="Short" timeStyle="Short"/></li>
		<li>내 패턴 : <fmt:formatDate value="${ current }" type="both" pattern="yyyy-MM-dd(E) HH:mm:ss(a)"/></li>
	</ul>
	
	<hr>
	
	<h3>3. setLocale/timeZone</h3>
	<pre>
	지역 설정을 통해 통화 기호나 시간 대역을 다르게 설정 가능
	</pre>
	
	<h4>대한민국</h4>
	금액 : <fmt:formatNumber value="1000000" type="currency"/>
	일시 : <fmt:formatDate value="${ current }" type="both" dateStyle="full" timeStyle="full"/>
	
	<h4>미국/뉴욕</h4>
	<fmt:setLocale value="en_us"/>
	금액 : <fmt:formatNumber value="1000000" type="currency"/>
	<fmt:timeZone value="America/New_York">
		일시 : <fmt:formatDate value="${ current }" type="both" dateStyle="full" timeStyle="full"/>
	</fmt:timeZone>
	
	<h4>영국/런던</h4>
	<fmt:setLocale value="en_UK"/>
	금액 : <fmt:formatNumber value="1000000" type="currency"/>
	<fmt:timeZone value="Europe/London">
		일시 : <fmt:formatDate value="${ current }" type="both" dateStyle="full" timeStyle="full"/>
	</fmt:timeZone>
</body>
</html>