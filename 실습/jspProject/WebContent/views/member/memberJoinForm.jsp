<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer {
		width:600px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	
	#joinForm table {
		width:100%;
		margin:auto;
	}
	
	#joinForm td {
		text-align:right;
	}
	
	input {
		margin-top:2px;
	}
	
	button {
		height:22px;
		width:80px;
		background:yellowgreen;
		border:yellowgreen;
		color:white;
		border-radius:5px;
	}
	
	button:hover {
		cursor:pointer;
	}
	
	#idCheck, #pwdResult {
		float:left;
	}
	
	#pwdResult {
		text-align:left;
	}
</style>
</head>
<body>
	<!-- 페이지를 이동해도 menubar는 계속 상단에 노출되도록 하자 -->
	<%@ include file="../common/menubar.jsp" %>
	
	<!-- 1. 회원 가입 -->
	<!-- 1_1. 회원가입 폼 작성 -->
	<div class="outer">
		<br>
		<h2 align="center">회원가입</h2>
		
		<form id="joinForm" name="joinForm" action="<%= request.getContextPath() %>/insert.me" method="post" onsubmit="return joinValidate();">
			<table>
				<tr>
					<td width="200px">* 아이디</td>
					<td><input type="text" maxlength="13" name="userId" required></td>
					<td width="200px">
						<!-- ajax를 이용한 중복 확인 : onclick 지우고 실행 -->
						<!-- <button id="idCheck" type="button" onclick="checkId()">중복확인</button> -->
						<button id="idCheck" type="button">중복확인</button>
					</td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" maxlength="15" name="userPwd" required></td>
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td><input type="password" maxlength="15" name="userPwd2" required></td>
					<td><label id="pwdResult"></label></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" maxlength="5" name="userName" required></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" maxlength="11" name="phone" placeholder="(-없이)01012345678"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
					<td></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address"></td>
					<td></td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<input type="checkbox" id="sports" name="interest" value="운동">
						<label for="sports">운동</label>
						<input type="checkbox" id="climbing" name="interest" value="등산">
						<label for="climbing">등산</label>
						<input type="checkbox" id="fishing" name="interest" value="낚시">
						<label for="fishing">낚시</label>
						<input type="checkbox" id="cooking" name="interest" value="요리">
						<label for="cooking">요리</label>
						<input type="checkbox" id="game" name="interest" value="게임">
						<label for="game">게임</label>
						<input type="checkbox" id="etc" name="interest" value="기타">
						<label for="etc">기타</label>
					</td>
					<td></td>
				</tr>
			</table>
			<br>
			<div class="btns" align="center">
				<button id="toMain" onclick="returnToMain()" type="button">메인으로</button>
				<!-- 아이디 중복 확인이 되었을 경우에만 '가입하기' 버튼 활성화 하기 -->
				<!-- <button id="joinBtn">가입하기</button> -->
				<button id="joinBtn" disabled>가입하기</button>
			</div>
		</form>
	</div>
	
	
	<script>
		
		// 1. 메인으로 돌아가기
		function returnToMain(){
			location.href="<%= request.getContextPath() %>";
		}
	
		// 2. 유효성 검사
		function joinValidate(){
			if(!(/^[a-z][a-z\d]{3,11}$/.test($("#joinForm input[name=userId]").val()))){
				alert('아이디는 영소문자로 시작해서 4~12자 입력(숫자 포함 가능)');
				$("#joinForm input[name=userId]").select();
				return false;
			}
			
			if($("#joinForm input[name=userPwd]").val() != $("#joinForm input[name=userPwd2]").val()){
				$("#pwdResult").text("비밀번호 불일치").css("color","red");
				return false;
			}
			
			if(!(/^[가-힣]{2,}$/.test($("#joinForm input[name=userName]").val()))){
				alert('이름은 한글로 2글자 이상 입력');
				$("#joinForm input[name=userName]").select();
				return false;
			}
			
			return true;
			
		}
	
		// 3. 회원 가입
		// InsertMemberServlet 만들어서 진행
		
		// 4. 아이디 중복체크
		function checkId(){
			window.open("idCheckForm.jsp", "checkForm", "width=300, height=200");
		}
		
		//---------------------------------------------------------------
		// ajax를 이용한 id 중복 확인
		$(function(){
			
			var isUsable = false;
			// 아이디 중복 시 false, 아이디 사용 가능 시 true -> 나중에 유효성 검사
			
			$("#idCheck").click(function(){
				var userId = $("#joinForm input[name='userId']");
				
				if(!userId || userId.val().length < 4){
					alert("아이디는 최소 4자리 이상이어야 합니다.");
					userId.focus();
				}else{
					// ajax로 중복 여부 확인
					$.ajax({
						url : "<%= request.getContextPath() %>/idCheck.me",
						type : "post",
						data : {userId:userId.val()},
						success : function(data){
							if(data == "fail"){
								alert('사용할 수 없는 아이디입니다.');
								userId.focus();
							}else{
								if(confirm("사용 가능한 아이디입니다. 사용하시겠습니까?")){
									userId.prop('readonly', true); 
									// -> 더 이상 userId에 값 입력해서 변경할 수 없도록
									isUsable = true;
									// -> 사용 가능하다는 flag 값
								}else{
									userId.focus();
								}
							}
						
							if(isUsable){
								// 아이디 중복 체크 후 사용 가능한 아이디이며 사용하기로 한 경우
								// 회원가입 버튼 활성화
								$("#joinBtn").removeAttr("disabled");
							}
						},
						error : function(){
							console.log('서버 통신 안됨');
						}
					});
				}
				
				
			});
		});
	</script>
	
</body>
</html>