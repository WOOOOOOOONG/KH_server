<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pizza = (String)request.getAttribute("pizza");
	String topping = (String)request.getAttribute("topping");
	int total = (int)request.getAttribute("total");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#pizza { color : red; }
	#topping { color : green; }
	#total { text-decoration : underline; }
</style>
</head>
<body>
	<h1>주문 내역</h1>
	<h2>
		피자는 <span id="pizza"><%= pizza %></span>,
		토핑은 
		<% if(topping.equals("")){ %>
			<span id="topping">없음</span>
		<% } else { %>
			<span id="topping"><%= topping %></span>
		<% } %>
		주문하셨습니다.
	</h2>
	<br><br>
	<h2>총합 : <span id="total"><%= total %></span></h2>
	<br>
	<h1 style="color:pink">즐거운 식사시간 되세요~</h1>
</body>
</html>