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
		<h2 align="center">������</h2>
		<table align="center">
			<tr>
				<td>* ���̵�</td>
				<td><input type="text" maxlength="13" name="userId"
					value="${ loginUser.userId }" readonly></td>
			</tr>
			<tr>
				<td>* ��й�ȣ</td>
				<td><input type="password" maxlength="15" name="userPwd"
					value="${ loginUser.userPwd }" readonly></td>
			</tr>
			<tr>
				<td>* �̸�</td>
				<td><input type="text" maxlength="5" name="userName"
					value="${ loginUser.userName }" readonly></td>
			</tr>
		</table>


		<!-- ��� üũ�ڽ� ó�� JSTL�� -->
		<c:forTokens items="${ loginUser.hobby }" delims="," var="checkValue">
			<c:if test="${ checkValue == '�' }">
				<c:set var="check1" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '���' }">
				<c:set var="check2" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '����' }">
				<c:set var="check3" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '�丮' }">
				<c:set var="check4" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '����' }">
				<c:set var="check5" value="checked" />
			</c:if>
			<c:if test="${ checkValue == '��Ÿ' }">
				<c:set var="check6" value="checked" />
			</c:if>
		</c:forTokens>

		<table align="center">
			<tr>
				<td><input type="checkbox" name="hobby" value="�" ${ check1 }>�
				</td>
				<td><input type="checkbox" name="hobby" value="���" ${ check2 }>���
				</td>
				<td><input type="checkbox" name="hobby" value="����" ${ check3 }>����
				</td>
				<td><input type="checkbox" name="hobby" value="�丮" ${ check4 }>�丮
				</td>
				<td><input type="checkbox" name="hobby" value="����" ${ check5 }>����
				</td>
				<td><input type="checkbox" name="hobby" value="��Ÿ" ${ check6 }>��Ÿ
				</td>
			</tr>
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
	<!-- * �۵� ���� *
		 JAVA > JSTL > HTML > Javascript -->
</body>
</html>