<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.*, java.util.*"%>
<%
	Board b = (Board)request.getAttribute("board");

	//USER_NO,USER_NAME 형태로 넘어온 값을 나눠줌
	String[] bWriter = b.getbWriter().split(",");
	
	int userNo = Integer.parseInt(bWriter[0]);
	b.setbWriter(bWriter[1]);
	
	// ajax 이후
	ArrayList<Reply> rlist = (ArrayList<Reply>)request.getAttribute("rlist");
	
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
	td {
		border:1px solid white;
	}
	
	.tableArea {
		border:1px solid white;
		width:450px;
		height:350px;
		margin:auto;
	}
	
	#content {
		height:230px;
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
	
	#deleteBtn, #updateBtn {
		background:orangered;
		border:orangered;
	}
	
	.replyArea {
		width:800px;
		color:white;
		background:black;
		margin:auto;
	}
	
	#replySelectArea {
		height:500px;
	}
	
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">게시판 상세보기</h2>
		<div class="tableArea">
			<table align="center">
				<tr>
					<td>분야</td>
					<td><span><%= b.getCategory() %></span></td>
					<td>제목</td>
					<td colspan="3"><span><%= b.getbTitle() %></span></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><span><%= b.getbWriter() %></span></td>
					<td>조회수</td>
					<td><span><%= b.getbCount() %></span></td>
					<td>작성일</td>
					<td><span><%= b.getModifyDate() %></span></td>
				</tr>
				<tr>
					<td colspan="6">내용</td>
				</tr>
				<tr>
					<td colspan="6"><p id="content"><%= (b.getbContent()).replace("\r\n", "<br>") %></p></td>
				</tr>
			
			</table>
			
			<div align="center">
				<button type="button" onclick="returnToList();">목록으로</button>
				<!-- 로그인한 회원이 글쓴이인 경우 -->
				<% if(userNo == loginUser.getUserNo()) { %>
					<button id="updateBtn" type="button" onclick="updateBoard();">수정</button>
					<button id="deleteBtn" type="button" onclick="deleteBoard();">삭제</button>
				<% } %>
			</div>
		</div>
	</div>

	<!-- ajax를 이용한 댓글 기능 구현 -->
	<div class="replyArea">
		<!-- 댓글 작성하는 부분 -->
		<div class="replyWriterArea">
			<table align="center">
				<tr>
					<td>댓글 작성</td>
					<td><textarea rows="3" cols="80" id="replyContent"></textarea></td>
					<td><button id="addReply">댓글 등록</button></td>
				</tr>
			</table>
		</div>
		
		<!-- 불러온 댓글 리스트 보여주는 부분 -->
		<div id="replySelectArea">
			<table id="replySelectTable" border="1" align="center">
			<% if(rlist != null){ %>
				<% for(Reply r : rlist) { %>
					<tr>
						<td width="100px"><%= r.getUserName() %></td>
						<td width="400px"><%= r.getrContent() %></td>
						<td width="200px"><%= r.getCreateDate() %></td>
					</tr>
				<% } %>
			<% } %>
			</table>
		</div>
	</div>

	<!-- 수정/삭제를 위해 -->
	<form action="" id="detailForm" method="post">
		<input type="hidden" name="bId" value="<%= b.getbId() %>">
	</form>
	
	<script>
		function returnToList(){
			location.href = "<%= contextPath %>/list.bo";
		}
		
		function updateBoard(){
			$("#detailForm").attr("action", "<%= contextPath %>/updateForm.bo");
			$("#detailForm").submit();
			
		}
		
		function deleteBoard(){
			$("#detailForm").attr("action", "<%= contextPath %>/delete.bo");
			$("#detailForm").submit();
		}
		
		// addReply 버튼 클릭 시 댓글 달기 기능을 실행했을 때 비동기적으로
		// 새로 갱신 된 댓글 리스트를 테이블에 적용 시키는 ajax
		$("#addReply").click(function(){
			var writer = <%= loginUser.getUserNo() %>;
			var bid = <%= b.getbId() %>;
			var content = $("#replyContent").val();
			
			$.ajax({
				url : "insertReply.bo",
				type : "post",
				dataType : "json",
				data : {writer:writer,
						content:content,
						bid:bid},
				success: function(data){
					console.log(data);
					
					$replyTable = $("#replySelectTable");
					$replyTable.html(""); // 기존 댓글 테이블 정보 초기화
					
					// 새로 받아온 갱신 된 댓글 리스트 들을 for문을 통해
					// 다시 table에 추가
					for(var key in data){ // 배열이므로 key 값은 인덱스
						
						var $tr = $("<tr>");
						var $writerTd = $("<td>").text(data[key].userName).css("width", "100px");
						var $contentTd = $("<td>").text(data[key].rContent).css("width", "400px");
						var $dateTd = $("<td>").text(data[key].createDate).css("width", "200px");
						
						$tr.append($writerTd);
						$tr.append($contentTd);
						$tr.append($dateTd);
						
						$replyTable.append($tr);
						
					}
					
					// 댓글 작성 부분 리셋
					$("#replyContent").val("");
					
					
				},
				error : function(){
					console.log('ajax 통신 실패');
				}
			});
			
			
			
			
			
			
			
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
	</script>
</body>
</html>