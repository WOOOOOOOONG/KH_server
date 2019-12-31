<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	// 중복체크창 아이디 입력 부분 초기값 및 확인버튼 활성/비활성 설정
	function idValue(){
		var userId;
		
		if("<%= request.getAttribute("result") %>" == "null"){
			// 부모창의 아이디 저장
			userId = opener.document.joinForm.userId.value;
		}else{
			// 중복 체크 후 아이디 저장
			userId = "<%= request.getAttribute("userId") %>";
			
			// 중복체크 확인 버튼 활성/비활성
			if(<%= request.getAttribute("result") %> == 0){
				document.getElementById("confirm").removeAttribute("disabled");
			}else{
				document.getElementById("confirm").setAttribute("disabled", "disabled");
			}
			
		}
		
		document.getElementById("userId").value = userId;
		
	}
	
	function confirm(){
		// 중복체크 확인 시 회원가입창 아이디 부분 비활성화
		if(<%= request.getAttribute("result") %> == 0){
			opener.document.joinForm.userId.value = document.getElementById("userId").value;
			opener.document.joinForm.userId.setAttribute("readonly", "readonly");
		}
		
		// 아이디 중복체크창 닫기
		if(opener != null){
			self.close();
		}
	}
</script>
<title>Insert title here</title>
</head>
<!-- onload를 이용해 idValue() 실행 -->
<body onload="idValue();">
	<b>아이디 중복 체크</b>
	<br>
	<form action="<%= request.getContextPath() %>/idCheck.me" id="idCheckForm" method="post">
		<input type="text" id="userId" name="userId">
		<input type="submit" value="중복확인">
	</form>
	<br>
	<!-- idCheckServlet 만든 뒤 -->
	<%
		if(request.getAttribute("result") != null) {
			int result = (int)request.getAttribute("result");
			
			if(result > 0){
	%>
				이미 사용중인 아이디입니다.
	<% 
			} else {
	%>
				사용 가능한 아이디입니다.
	<%
			}
		}
	%>
	
	<br>
	<br>
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	<input type="button" id="confirm" value="확인" onclick="confirm();" disabled="disabled">
	
</body>
</html>