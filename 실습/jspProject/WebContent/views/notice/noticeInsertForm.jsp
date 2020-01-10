<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.text.SimpleDateFormat" %>
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer {
		width:800px;
		height:500px;
		background:black;
		color:white;
		margin:auto;
		margin-top:50px;
	}
	
	.tableArea {
		width:450px;
		height:350px;
		margin:auto;
	}
	
	button {
		height:22px;
		width:80px;
		background:yellowgreen;
		border:yellowgreen;
		color:white;
		border-radius:5px;
	}
	
	button:hover{
		cursor:pointer;
	}
	
	#submit {
		background:orangered;
		border:orangered;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">공지사항 작성</h2>
			<div class="tableArea">
				<form action="<%= contextPath %>/insert.no" method="post">
					<table>
						<tr>
							<td>제목</td>
							<td colspan="3"><input type="text" size="50" name="title"></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td>
								<input type="text" value="<%= loginUser.getUserName() %>" name="writer" readonly>
							</td>
							<td>작성일</td>
							<td><input type="date" name="date" value="<%= today %>"></td>
						</tr>
						<tr>
							<td>내용</td>
						</tr>
						<tr>
							<td colspan="4">
								<textarea name="content" cols="60" rows="15" style="resize:none;"></textarea>
							</td>
						</tr>
					</table>
					<br>
					<div align="center">
						<button type="button" onclick="javascript:history.back();">취소</button>
						<button id="submit" type="submit">등록</button>
					</div>
				</form>
			</div>
	</div>
</body>
</html>