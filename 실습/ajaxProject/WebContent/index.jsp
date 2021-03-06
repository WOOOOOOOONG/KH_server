<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- ajax 개요 --%>
	<%-- 
		서버로부터 데이터를 가져와 전체 페이지를 고치지 않고 일부만 로드할 수 있게 하는 기법
		--> 즉, 비동기식 요청을 보내는데 필요한 기술
		
		* 동기식/비동기식
		- 동기식 : 서버와 클라이언트가 동시에 통신하여 프로세스를 수행 및 종료까지 같이함
				만약 서버에서 호출된 결과까지의 시간이 지연이 생길 경우 웹에서는 아무 작동
				없이 하염없이 기다려야 함. 결과를 받고 나서야 다른 일들을 할 수 있음.
		- 비동기식 : 페이지 리로딩 없이 동기식의 서버 요청 사이사이 추가적인 요청과 처리가 가능함.
				즉, 서버에서 요청한 결과를 받기까지 아무런 동작을 할 수 없는게 아니라 다른걸 하면서
				응답을 바로 받을 수 있음.
			--> 아이디 중복체크, 검색어 자동완성, 댓글, 실시간 검색 로딩
			
		* 단점
		- 한 페이지 내에서 지속적으로 사용시 리소스가 계속 쌓여 페이지가 느려질 수 있음.
		- 페이지 내 복잡도가 기하급수적으로 증가, 에러 발생 시 디버깅이 어려움
		
		* AJAX를 구현하는 방식에는 JavaScript와 jQeury 방식이 있는데 그 중 실제로 많이 사용하는
		  방식으로 jQuery 방식(코드가 간결하고 사용하기 쉽다)
	--%>
	<h1 align="center">JavaScript를 이용한 Ajax 테스트</h1>
	<h3>1. 버튼 클릭시 Get방식으로 서버에 데이터 전송 및 응답</h3>
	<button onclick="jsAjax1();">Get방식 전송</button>
	<p id="test1"></p>
	<script>
		function jsAjax1() {
			// 1. XMLHttpRequest 객체 생성
			xhr = new XMLHttpRequest();
			
			// 자바스크립트는 원래 브라우저 버젼벌 호환성 검사가 필요하지만 생략~
			
			// 2. onreadystatechange : Ajax 통신에 대한 응답 상태의 변경이 있을 경우
			// 실행할 함수(Ajax 통신이 성공한 경우에 대한 동작)
			xhr.onreadystatechange = function() {
				// 1) readyState : 서버 응답 상태 확인(Ajax 통신 진행상황 확인)
				/* 
					0 : request not initialized
					1 : server connection established
					2 : request received
					3 : processing request
					4 : request finished and response is ready
				*/
				if(xhr.readyState == 4) {
					// 요청이 끝났고 그에 해당하는 응답이 왔을 경우
					
					// 2) status : HTTP 응답 상태 코드(응답이 정상적으로 이루어졌는지 확인)
					/*
						200 : "OK"
						403 : "Forbidden"
						404 : "Not Found"
					*/
					if(xhr.status == 200) {
						console.log('jsAjax1() - ajax 통신 성공!');
						
						// xhr.responseText : 응답 데이터 문자열을 담고 있다.
						var str = xhr.responseText;
						document.getElementById("test1").innerHTML = str;
					}else if(xhr.status == 404) {
						console.log('jsAjax1() - ajax 통신 실패!');
					}
				}
			}
			// 3. open() : 서버와 데이터 교환시 필요한 정보 입력(요청 방식, 대상(서버), 동기/비동기)
			xhr.open("GET", "<%=request.getContextPath()%>/jsAjax1.do?name=홍길동&age=20", true);
			
			// 4. send() : 서버로 데이터 교환 요청
			xhr.send();
		}
	</script>

	<h3>2. 버튼 클릭 시 POST 방식으로 서버에 데이터 전송 및 응답</h3>
	<button onclick="jsAjax2();">POST방식 전송</button>
	<p id="test2"></p>
	<script>
		function jsAjax2() {
			// 1 XMLHttpRequest 객체 생성
			xhr = new XMLHttpRequest();
			
			// 2. onreadystatechange
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4 && xhr.status == 200) {
					console.log("jsAjax2() - ajax 통신 성공!");
					
					var str = xhr.responseText;
					
					document.getElementById("test2").innerHTML = str;
				}
			}
			
			// 3. open() : 서버와 데이터 교환 시 필요한 정보 입력
			xhr.open("POST", "<%=request.getContextPath()%>
		/jsAjax2.do");

			// **** POST 방식 데이터 전송시 send() 호출 전 mime type을 설정해주어야 함 ****
			// POST 전송 시 header에 추가로 설정하지 않으면 전송한 파라미터를 인식하지 못함
			// key=value&key=value&...
			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded;");
			// HTTP요청 헤더의 값을 설정. setRequestHeader(header(설정된값을 가진 헤더이름), value(헤더의 본문에 설정될 값))

			// 4. send()
			xhr.send("name=김말똥&age=30"); // send 시 데이터 전송
		}
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<h1 align="center">jQuery를 이용한 Ajax 테스트</h1>
	<h3>1. 버튼 클릭시 GET 방식으로 서버에 데이터 전송 및 응답</h3>
	입력 :
	<input type="text" id="input1">
	<button id="btn1">전송</button>
	응답 :
	<input type="text" id="output1" style="width: 300px" readonly>
	<script>
		$(function() {
			// 1. 버튼 클릭시 GET 방식으로 서버에 입력값 전송 및 응답
			$("#btn1").click(function() {
				var input = $("#input1").val();

				$.ajax({
					// url : 데이터를 전송할 url(필수!!)
					url : "jqAjax1.do",

					// data : 요청 시 전달할 파라미터 설정
					data : {
						input : input
					},
					// key:value

					// type : 전송방식(GET/POST)
					type : "get",

					// success : Ajax 통신 성공 시 처리할 함수를 지정하는 속성
					success : function(result) {
						// result 매개변수 : 서버에서 응답이 왔을 때 그 값이 저장되는 변수
						// 매개변수명 임의지정 가능
						console.log('Ajax 통신 성공!');
						$("#output1").val(result);
					},

					// error : Ajax 통신 실패 시 처리할 함수를 지정하는 속성
					error : function() {
						console.log('Ajax 통신 실패...');
					},

					// complete : 통신 성공/실패 여부 상관없ㅇ ㅣ실행
					complete : function() {
						console.log('무조건 호출~!');
					}
				});
			});
		});
	</script>

	<h3>2. 버튼 클릭시 POST 방식으로 서버에 데이터 전송 및 응답</h3>
	입력 :
	<input type="text" id="input2">
	<button id="btn2">전송</button>
	응답 :
	<input type="text" id="output2" style="width: 300px" readonly>

	<script>
		$(function() {
			$("#btn2").click(function() {
				var input = $("#input2").val();

				$.ajax({
					url : "jqAjax2.do",
					data : {
						input : input
					},
					type : "post",
					success : function(result) {
						console.log("Ajax 통신 성공!");
						$("#output2").val(result);
					},
					error : function(e) {
						console.log(e);
					},
					complete : function() {
						console.log("무조건 호출");
					}
				});
			});
		});
	</script>

	<h3>3. 버튼 클릭시 POST 방식으로 서버에 여러개의 데이터 전송 및 응답</h3>
	이름 :
	<input type="text" id="input3_1"> 나이 :
	<input type="text" id="input3_2">
	<button id="btn3">전송</button>
	응답 :
	<input type="text" id="output3" style="width: 300px" readonly>

	<script>
		$(function() {
			$("#btn3").click(function() {
				var input3_1 = $("#input3_1").val();
				var input3_2 = $("#input3_2").val();

				$.ajax({
					url : "jqAjax3.do",
					data : {
						name : input3_1,
						age : input3_2
					},
					type : "post",
					success : function(result) {
						$("#output3").val(result);
					},
					error : function() {
						$("#output3").val("ajax 통신 실패");
					}
				});
			});
		});
	</script>

	<h3>4. 서버로 기본형 데이터 전송 후, 응답을 객체(Object)로 받기</h3>
	<h4>번호를 입력하여 조회하고자 하는 사용자 정보를 요청, 사용자가 없는 경우 "사용자 정보가 없습니다." 출력</h4>

	회원정보 입력 :
	<input type="text" id="input4">
	<button id="btn4">조회</button>
	<textarea id="textarea4" rows="4" cols="30"></textarea>

	<script>
		$(function() {
			// JSONObject를 서버로부터 전달받아
			// dataType : "json"을 이용하여 처리
			$("#btn4").click(
					function() {
						var input = $("#input4").val();

						$.ajax({
							url : "jqAjax4.do",
							data : {
								input : input
							},
							type : "get",
							dataType : "json", // 응답 데이터의 형식을 text가 아닌 json으로 지정
							success : function(obj) {
								console.log(obj);

								var result = "";

								if (obj != null) {
									result = "번호 : " + obj.no + "\n" + "이름 : "
											+ obj.name + "\n" + "나이 : "
											+ obj.age + "\n" + "성별 : "
											+ obj.gender;
								} else {
									result = "사용자 정보가 없습니다.";
								}

								$("#textarea4").val(result);
							},
							error : function() {
								$("#textarea4").val("ajax 통신 실패");
							}
						});
					});
		});
	</script>

	<h3>5. 서버로 기본형 데이터를 전송 후, 응답을 리스트(List) 형태로 받기</h3>
	<h4>선택한 성별을 가진 모든 회원 정보 가져오기</h4>
	성별 : 남
	<input type="radio" name="chk_gender5" value="남" checked> 여
	<input type="radio" name="chk_gender5" value="여">
	<button id="btn5">조회</button>
	<br>
	<br>
	<textarea id="textarea5" rows="5" cols="30"></textarea>
	<script>
		$(function() {
			$("#btn5").click(
					function() {
						var gen = $("input[name='chk_gender5']:checked").val();
						$.ajax({
							url : "jqAjax5.do",
							data : {
								gender : gen
							},
							type : "get",
							dataType : "json",
							success : function(list) {
								console.log(list);

								// $.each(배열명, function(index){});
								// --> 배열명[index] 각 요소에 접근 가능
								var result = "";

								$.each(list, function(i) {
									result += list[i].no + " / " + list[i].name
											+ " / " + list[i].age + " / "
											+ list[i].gender + "\n";
								});

								$("#textarea5").val(result);
							},
							error : function() {
								console.log("ajax 통신 실패");
							}
						});
					});
		});
	</script>

	<br>

	<h3>6. 서버로 데이터 전송 후, 응답을 맵(Map) 형태로 받아서 테이블에 출력하기</h3>
	<h4>조회하고자 하는 회원의 이름 키워드를 입력해서 조회되는 회원들 정보와 전달된 키워드를 받아오기</h4>
	이름 :
	<input type="text" id="input6" width="300">
	<button id="btn6">검색</button>
	<br>
	<br>
	<table id="memberTable6" border="1" style="text-align: center">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

	<script>
		$(function() {
			$("#btn6").click(function() {
				var input = $("#input6").val();

				$.ajax({
					url : "jqAjax6.do",
					data : {
						keyword : input
					},
					dataType : "json",
					type : "get",
					success : function(map) {
						console.log(map);

						console.log(map["jArr"]);
						console.log(map["keyword"]);

						var $tableBody = $("#memberTable6 tbody");
						// var tableBody로 변수를 선언하지 않고 $tableBody로
						// 변수를 선언하는 이유는?
						// tableBody --> 자바스크립트 변수, 스크립트만 사용 가능
						// $tableBody --> jQuery 변수, jQuery에서 사용하는 내장함수들 모두 사용 가능
						// 따라서 그냥 $를 첫글자에 써서 그것이 jQuery의 확장 객체임을 쉽게 구별하려는 의도로 통상 사용

						$tableBody.html("");

						$.each(map["jArr"], function(index, value) {
							console.log(value);

							var $tr = $("<tr>");
							var $noTd = $("<td>").text(value.no); // <td>1</td>
							var $nameTd = $("<td>").text(value.name); // <td>김영희</td>
							var $ageTd = $("<td>").text(value.age); // <td>30</td>
							var $genTd = $("<td>").text(value.gender); // <td>여</td>

							$tr.append($noTd);
							$tr.append($nameTd);
							$tr.append($ageTd);
							$tr.append($genTd);
							// <tr> 사이에 위의 <td> 요소들이 모두 들어간다.

							$tableBody.append($tr);
						});
					},
					error : function() {
						console.log('ajax 통신 실패!');
					},
				});
			});
		});
	</script>

	<h3>7. Gson을 이용한 List 반환</h3>
	<button id="gsonListBtn">list 가져오기</button>
	<br>
	<textarea id="textarea7" rows="10" cols="30"></textarea>

	<script>
		$(function() {
			$("#gsonListBtn").click(
					function() {
						$.ajax({
							url : "jqAjax7.do",
							type : "get",
							success : function(list) {
								console.log(list);

								var result = "";
								$.each(list, function(index, value) {
									result += value.no + " / " + value.name
											+ " / " + value.age + " / "
											+ value.gender + "\n"
								});

								$("#textarea7").val(result);
							},
							error : function() {
								console.log("ajax 통신 실패!");
							}
						});
					});
		});
	</script>

	<h3>8. 연습</h3>
	<h4>번호를 입력하여 조회하고자 하는 사용자 정보를 요청, 해당 결과를 테이블에 누적시킨다. 없는 번호를 입력했을 시
		에러나지 않도록 처리할 것.</h4>
	회원번호 입력 :
	<input type="text" id="input8">
	<button id="btn8">조회</button>
	<br>
	<br>

	<table id="memberTable8" border="1" style="text-align: center">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		<tbody>
		</tbody>
	</table>
	<script>
		$(function() {
			$("#btn8").click(function() {
				var input = $("#input8").val();

				$.ajax({
					url : "jqAjax8.do",
					data : {
						keyword : input
					},
					dataType : "json",
					type : "get",
					success : function(user) {

						// var tableBody로 변수를 선언하지 않고 $tableBody로
						// 변수를 선언하는 이유는?
						// tableBody --> 자바스크립트 변수, 스크립트만 사용 가능
						// $tableBody --> jQuery 변수, jQuery에서 사용하는 내장함수들 모두 사용 가능
						// 따라서 그냥 $를 첫글자에 써서 그것이 jQuery의 확장 객체임을 쉽게 구별하려는 의도로 통상 사용

						$tableBody.html("");

						if (user != null) {
							var $tableBody = $("#memberTable8 tbody");

							var $tr = $("<tr>");
							var $noTd = $("<td>").text(user.no); // <td>1</td>
							var $nameTd = $("<td>").text(user.name); // <td>김영희</td>
							var $ageTd = $("<td>").text(user.age); // <td>30</td>
							var $genTd = $("<td>").text(user.gender); // <td>여</td>

							$tr.append($noTd);
							$tr.append($nameTd);
							$tr.append($ageTd);
							$tr.append($genTd);
							// <tr> 사이에 위의 <td> 요소들이 모두 들어간다.

							$tableBody.append($tr);
						}
					},
					error : function() {
						console.log('ajax 통신 실패!');
					},
				});
			});
		});
	</script>
</body>
</html>