<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<c:if test="${ !empty loginUser }">
		<h2 align="center">내정보</h2>
		<table align="center">
			<tr>
				<td>* 아이디</td>
				<td><input type="text" maxlength="13" name="userId"
					value="${ loginUser.userId }" readonly></td>
			</tr>
			<tr>
				<td>* 비밀번호</td>
				<td><input type="password" maxlength="15" name="userPwd"
					value="${ loginUser.userPwd }" readonly></td>
			</tr>
			<tr>
				<td>* 이름</td>
				<td><input type="text" maxlength="5" name="userName"
					value="${ loginUser.userName }" readonly></td>
			</tr>
		</table>


		<!-- 취미 체크박스 처리 JSTL로 -->
		<c:forTokens items="${ loginUser.hobby }" delims="," var="checkValue">
			<c:if test="${ checkValue == '운동' }">
				<c:set var="check1" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '등산' }">
				<c:set var="check2" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '낚시' }">
				<c:set var="check3" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '요리' }">
				<c:set var="check4" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '게임' }">
				<c:set var="check5" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '기타' }">
				<c:set var="check6" value="checked" />
			</c:if>
		</c:forTokens>

		<table align="center">
			<tr>
				<td><input type="checkbox" name="hobby" value="운동" ${ check1 }>운동
				</td>
				<td><input type="checkbox" name="hobby" value="등산" ${ check2 }>등산
				</td>
				<td><input type="checkbox" name="hobby" value="낚시" ${ check3 }>낚시
				</td>
				<td><input type="checkbox" name="hobby" value="요리" ${ check4 }>요리
				</td>
				<td><input type="checkbox" name="hobby" value="게임" ${ check5 }>게임
				</td>
				<td><input type="checkbox" name="hobby" value="기타" ${ check6 }>기타
				</td>
			</tr>
			<tr>
				<td><button onclick="returnToMain();">메인으로</button></td>
			</tr>
		</table>
	</c:if>
	
	<script>
		function returnToMain() {
			location.href="${contextPath}/views/main/main.jsp";
		}
	</script>
	<!-- * 작동 순서 *
		 JAVA > JSTL > HTML > Javascript -->
</body>
</html>