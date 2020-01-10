<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, notice.model.vo.Notice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		width:650px;
		height:350px;
		margin:auto;
	}
	
	#listArea {
		border: 1px solid white;
		text-align:center;
		margin:auto;
	}
	
	.searchArea {
		width:650px;
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
	
	#noticeInsert {
		background:orangered;
		border:orangered;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h2 align="center">공지사항2</h2>
			<div class="tableArea">
				<table id="listArea">
					<tr>
						<th>글번호</th>
						<th width="300">글제목</th>
						<th width="100">작성자</th>
						<th>조회수</th>
						<th width="100">작성일</th>
					</tr>
					<!-- 
						공지사항 글이 존재하지 않을 수도 있으므로
						list가 비어있는지 아닌지 검사
					 -->
					<c:choose>
						<c:when test="${ empty list }">
						 	<tr>
						 		<td colspan="5">존재하는 공지사항이 없습니다.</td>
						 	</tr>
					 	</c:when>
					 	<c:otherwise>
						 	<c:forEach var="n" items="${ list }">
							 	<tr>
							 		<td>${ n.nNo }</td>
							 		<td>${ n.nTitle }</td>
							 		<td>${ n.nWriter }</td>
							 		<td>${ n.nCount }</td>
							 		<td>${ n.nDate }</td>
							 	</tr>
						 	</c:forEach>
						 </c:otherwise>
					</c:choose>
				</table>
			</div>
			
			<div class="searchArea" align="center">
			<form action="${ contextPath }/search.no" method="get" onsubmit="return checkSearchCondition();">
				<select id="searchCondition" name="searchCondition">
					<option value="----">----</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select> 
				<input type="search" name="search">
				<button type="submit">검색하기</button>
			</form>
			<script>
				function checkSearchCondition(){
					if($("#searchCondition option:selected").val() == '----'){
						return false;
					}
					return true;
				}
			</script>
				<!-- 공지사항 글쓰기 기능 -->
				<!-- 공지사항은 보통 관리자만 쓸 수 있다. 따라서 관리자만 쓸 수 있도록 조건을 걸자. -->
				<c:if test="${ !empty loginUser and loginUser.userId eq 'admin' }">
					<!-- 매번 request.getContextPath()를 작성하기에는 번거로우므로 
					menubar.jsp에 변수화 시켜놓고 모든 페이지에서 사용하자. -->
					<button id="noticeInsert" type="button" onclick="location.href='${ contextPath }/views/notice/noticeInsertForm.jsp'">작성하기</button>
				</c:if>
			</div>
			
			<c:if test="${ !empty searchCondition and !empty search }">
				<p align="right">${ searchCondition } : ${ search }의 검색결과</p>
			</c:if>
	</div>
	
	<script>
		// 공지사항 상세보기 기능(jquery를 통해 작업)
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"darkgrey", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css("background","black");
			}).click(function(){
				var num = $(this).parent().children().eq(0).text();
				console.log(num);
				// 쿼리 스트링을 이용하여 get방식으로 (url노출) 글 번호를 server로 전달
				location.href="${ contextPath }/detail.no?nno=" + num;
			});
			
		});
	</script>
</body>
</html>