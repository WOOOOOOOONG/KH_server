<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member m = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>정보수정</h2>
		
		<form id="updateForm" name="updateForm" action="<%= request.getContextPath() %>/mupdate" method="post">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName" value="<%= m.getUserName() %>"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel"name="phone" value="<%= m.getPhone() %>"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="<%= m.getEmail() %>"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="<%= m.getAddress() %>"></td>
				</tr>
			</table>
			<button type="submit">수정하기</button>
		</form>
</body>
</html>