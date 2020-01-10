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
	<!-- 
	1. 메뉴바 include
	2. 로그인 유저가 있을 때만 공지사항 테이블 보여주기
	3. 공지사항 테이블에는 가지고 있는 모든 값 보여주기
	4. 메인으로 돌아가는 버튼
 -->
	<jsp:include page="../common/menubar.jsp" />
	<c:if test="${ !empty loginUser }">
		<table align="center">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="li" items="${ list }">
				<tr>
					<td>${ li.nid }</td>
					<td>${ li.title }</td>
					<td>${ li.content }</td>
					<td>${ li.writer }</td>
				</tr>
			</c:forEach>
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
</body>
</html>