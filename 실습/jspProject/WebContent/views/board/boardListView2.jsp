<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:900px;
		height:500px;
		background:black;
		color:white;
		margin:auto;
		margin-top:50px;
	}
	table {
		border:1px solid white;
		text-align:center;
	}
	.tableArea {
		width:650px;
		height:350px;
		margin:auto;
	}
	.searchArea {
		width:650px;
		margin:auto;
	}
	#searchBtn, #insertBtn {
		height:22px;
		width:80px;
		background:yellowgreen;
		border:yellowgreen;
		color:white;
		border-radius:5px;
	}
	
	#searchBtn:hover, #insertBtn:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="outer">
		<br>
		
		<h2 align="center">게시판2</h2>
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<th width="100">글번호</th>
					<th width="100">카테고리</th>
					<th width="300">글제목</th>
					<th width="100">작성자</th>
					<th width="100">조회수</th>
					<th width="150">작성일</th>
				</tr>
				<c:choose>
					<c:when test="${ empty list }">
					<tr>
						<td colspan="6">조회된 리스트가 없습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="b" items="${ list }">
							<tr>
								<input type="hidden" value="${ b.bId }">
								<td>${ b.bId }</td>
								<td>${ b.category }</td>
								<td>${ b.bTitle }</td>
								<td>${ b.bWriter }</td>
								<td>${ b.bCount }</td>
								<td>${ b.modifyDate }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
			</table>
		</div>
		<!-- ---------- 페이징 바 ---------- -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='${ contextPath }/list.bo?currentPage=1'"> &lt;&lt; </button>
			
			<!-- 이전 페이지로 (<) -->
			<c:choose>
			<c:when test="${ pi.currentPage eq 1 }">
				<button disabled> &lt; </button>
			</c:when>
			<c:otherwise>
				<button onclick="location.href='${ contextPath }/list.bo?currentPage=${ pi.currentPage -1 }'"> &lt; </button>
			</c:otherwise>
			</c:choose>
			
			<!-- 10개의 페이지 목록 -->
			<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
				<c:choose>
					<c:when test="${ p eq pi.currentPage }">
						<button disabled> ${ p } </button>
					</c:when>
					<c:otherwise>
					<button onclick="location.href='${ contextPath }/list.bo?currentPage=${ p }'"> ${ p } </button>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 페이지로(>) -->
			<c:choose>
				<c:when test="${ pi.currentPage eq pi.maxPage }">
					<button disabled> &gt; </button>
				</c:when>
				<c:otherwise>
					<button onclick="location.href='${ contextPath }/list.bo?currentPage=${ pi.currentPage + 1 }'"> &gt; </button>
				</c:otherwise>
			</c:choose>
			
			<!-- 맨 끝으로(>>) -->
			<button onclick="location.href='${ contextPath }/list.bo?currentPage=${ pi.maxPage }'"> &gt;&gt; </button>
		
		</div>
		
		<!-- 공지사항 때와 마찬가지로 검색 부분은 있다!! 하지만 기능 구현은 우선 안하겠다. -->
		<div class="searchArea" align="center">
			<select id="searchCondition" name="searchCondition">
				<option>-----</option>
				<option value="category">카테고리</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search">
			<button id="searchBtn" type="submit">검색하기</button>
			
			<c:if test="${ !empty loginUser }">
				<button id="insertBtn" onclick="location.href='${ contextPath }/views/board/boardInsertForm.jsp'">작성하기</button>
			</c:if>
		</div>
	</div>
	
		
		<script>
		// 3. 게시판 상세보기 기능 구현하자!
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"black"});
			}).click(function(){
				var bId = $(this).parent().children("input").val();
				
				<c:choose>
					<c:when test="${ !empty loginUser }">
						location.href="${contextPath}/detail.bo?bId="+bId;
					</c:when>
					<c:otherwise>
						alert("로그인해야만 상세보기가 가능합니다!");
					</c:otherwise>
				</c:choose>
			});
		})
	</script>
	
</body>
</html>