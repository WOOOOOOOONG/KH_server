<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.model.vo.Person, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL 연산</h2>
	<p>
		EL의 용도는 속성 값들을 화면에 뿌리는 용도이나
		산술 연산 및 논리 연산을 지원하며 간단한 논리 연산은 자주 사용된다.
	</p>
	
	<h3>산술연산</h3>
	10 더하기 5 : ${ 10 + 5 } <br>
	10 빼기 5 : ${ 10 - 5 } <br>
	10 곱하기 5 : ${ 10 * 5 } <br>
	10 나누기 5 : ${ 10 / 5 } 또는 ${ 10 div 5 } <br>
	<!-- 에러 발생하지만 문제 없음 -->
	10 나누기 7의 나머지 : ${ 10 % 7 } 또는 ${ 10 mod 7 } <br>
	
	<h3>객체 비교 연산</h3>
	<%
		String sOne = "안녕";
		String sTwo = new String("안녕");
		
		Person pOne = new Person("홍길동", 20, '남');
		Person pTwo = new Person("홍길동", 20, '남');
		
		// 페이지 스코프에 담기
		pageContext.setAttribute("sOne", sOne);
		pageContext.setAttribute("sTwo", sTwo);
		pageContext.setAttribute("pOne", pOne);
		pageContext.setAttribute("pTwo", pTwo);
	%>
	<table border="1">
		<tr>
			<th>비교식</th>
			<th>표현식</th>
			<th>el</th>
		</tr>
		<tr>
			<td>sOne == sTwo</td>
			<td><%= sOne == sTwo %></td>
			<td>${ sOne == sTwo } 또는 ${ sOne eq sTwo }</td> <!-- not equal -->
		</tr>
		<tr>
			<td>sOne != sTwo</td>
			<td><%= sOne != sTwo %></td>
			<td>${ sOne != sTwo } 또는 ${ sOne ne sTwo }</td> <!-- not equal -->
		</tr>
		<tr>
			<td>pOne = pTwo</td>
			<td><%= pOne == pTwo %></td>
			<td>${ pOne == pTwo } 또는 ${ pOne eq pTwo }</td> <!-- Person에 equals를 사용(따로 만들어두면 좋음) -->
		</tr>
		<tr>
			<td>pOne != pTwo</td>
			<td><%= pOne != pTwo %></td>
			<td>${ pOne != pTwo } 또는 ${ pOne ne pTwo }</td>
		</tr>
	</table>
	<!-- el의 == 연산은 equals()와 같은 동작을 한다.
		만약 Person에 equals()를 오버라이딩하면(모든 필드의 값이 같으면 같다고 본다)
		처음과 반대되는 값이 나온다 -->
		
	<br><br>
	
	<h4>숫자형 자동 형변환</h4>
	<%
		pageContext.setAttribute("big", 10);
		pageContext.setAttribute("small", 3);
		// int형 값인 10, 3을 세팅했지만
		// 웹 애플리케이션 객체에 setAttribte된 값은 Object 타입으로 저장된다.
	%>
	
	scriptlet : <%-- <%= pageContext.getAttribute("big") + 	pageContext.setAttribute("small"); %> --%>
	<!-- 스크립틀릿을 이요해서는 Object 타입끼리 더하기가 성립되지 않음 -->
	
	<br>
	
	el : ${ big + small }
	<!-- el은 scope에 속성으로 담긴 타입은 Object를 자동으로 인식하여 형변환 후 연산을 처리함 -->
	<br>
	
	<h4>숫자형 자동 형변환 + 비교연산</h4>
	big &gt; small : ${ big > small } 또는 ${ big gt small }<br> 
	<!-- greater than -->
	big &lt; small : ${ big < small } 또는 ${ big lt small }<br>
	<!-- less than -->
	big &gt;= small : ${ big >= small } 또는 ${ big ge small }<br>
	<!-- greater or equal -->
	big &lt;= small : ${ big <= small } 또는 ${ big le small }<br>
	<!-- less or equal --> 
	
	<h4>객체가 null 또는 비어있는지 체크</h4>
	<%
		ArrayList<String> list = new ArrayList<>();
		list.add(sOne);
		pageContext.setAttribute("list", list);
	%>
	\${ empty list } = ${ empty list }<br>
	\${ !empty list } = ${ !empty list }<br><br>
	
	<h4>논리연결연산자/부정연산자</h4>
	${ true and true } 또는 ${ true && true  }<br>
	${ true or true } 또는 ${ true || true }<br>
	${ !(big < small) } 또는 ${ not(big < small) }
</body>
</html>