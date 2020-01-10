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
	1. �޴��� include
	2. �α��� ������ ���� ���� �������� ���̺� �����ֱ�
	3. �������� ���̺��� ������ �ִ� ��� �� �����ֱ�
	4. �������� ���ư��� ��ư
 -->
	<jsp:include page="../common/menubar.jsp" />
	<c:if test="${ !empty loginUser }">
		<table align="center">
			<tr>
				<th>�۹�ȣ</th>
				<th>����</th>
				<th>����</th>
				<th>�ۼ���</th>
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
				<td><button onclick="returnToMain();">��������</button></td>
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