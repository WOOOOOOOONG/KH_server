<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.model.vo.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test Core Page</h1>
	<h3>1. 변수</h3>
	<pre>
	* 변수 선언 (c:set)
	- 변수를 선언하고 초기값을 대입하는 기능을 가진 태그
	- 변수 선언 시 scope를 지정할 수 있음. 기본 scope는 pageScope
	- 사용 방법
		1) 변수 타입은 별도로 선언하지 않는다.
		2) 초기 값은 반드시 지정해야 한다.
		3) c:set으로 선언한 변수는 EL 안에서 사용 가능
			하지만 스크립틀릿 요소에서는 사용할 수 없음.
	</pre>
	<c:set var="num1" value="10"/>
	<c:set var="num2" value="20" scope="request"/>
	
	<c:set var="result" value="${ num1 + num2 }" scope="session"/>
	
	num1 변수값 : ${ num1 }<br>
	num2 변수값 : ${ num2 }<br>
	${ num1 } + ${ num2 } = ${ result }<br>
	
	${ pageScope.num1 } <br>
	${ requestScope.num2 } <br>
	${ sessionScope.result } <br>
	${ requestScope.result } <br>
	위의 값은 출력되지 않는다.<!-- session으로 만들었기 때문에 그보다 작은 request로는 출력되지 않음. -->
	
	<h5>array</h5>
	<c:set var="arr" scope="request">
		red, blue, yellow, pink, green
	</c:set>
	arr 배열값 : ${ arr } <br>
	
	<hr>
	
	<pre>
	* 변수 삭제(c:remove)
	지정한 변수를 모든 scope에서 검색해 삭제함.
	또는 지정한 scope만 삭제도 가능
	</pre>
	
	<c:set var="result" value="9999" scope="request"/>
	삭제 전 \${ result } : ${ result } <br>
	
	1) 특정 scope에서 삭제
	<c:remove var="result" scope="request"/><br>
	
	삭제 후 \${ result } : ${ result } <br>
	
	2) 모든 scope에서 삭제
	<c:remove var="result"/><br>
	
	모두 삭제 후 \${ result } : ${ result } <br>
	
	<hr>
	
	<pre>
	* 변수 출력(c:out)
	데이터를 출력할 때 사용하는 태그
	&lt; &gt;, & 특수문자를 자동으로 이스케이프 시퀀스(escape sequence)로 변환 가능.
	</pre>
	
	<h4>c:out 테스트입니다.</h4>
	그대로 출력 : <c:out value="<b>태그로 출력하기</b>" escapeXml="true"/><br>
	태그로 해석되어 출력 : <c:out value="<b>태그로 출력하기</b>" escapeXml="false"/><br>
	기본 값 출력 : <c:out value="${ requestScope.result }" default="없음"/>
	
	<hr>
	
	<h3>2. 조건문 - IF (c:if test="조건식")</h3>
	<pre>
	- JAVA의 if문과 비슷한 역할을 하는 태그
	- 위의 태그 사용시 조건식은 test라는 속성의 값으로 지정해야 함
	  이 때 조건식은 반드시 EL 형식으로 기술해야 함.
	</pre>
	
	<c:if test="${ num1 > num2 }">
		num1이 큽니다.
	</c:if>
	
	<c:if test="${ num1 <= num2 }">
		num2가 큽니다.
	</c:if>
	
	<br>
	<hr>
	
	<h3>3. 조건문 - Choose (c:choose, c:when, c:otherwise)</h3>
	<pre>
	- Java의 if-else문 또는 switch문과 비슷한 역할을 하는 태그<br>
	- 각 조건들을 c:choose문의 하위 요소로 c:when을 통해서 작성
	(default 값으로는 c:otherwise)
	</pre>
	
	<c:set var="no" value="0"/>
	<c:choose>
		<c:when test="${ no eq 0 }">
			처음 뵙겠습니다. <br>
		</c:when>
		<c:when test="${ no eq 1 }">
			다시 뵙게 되어 반갑습니다. <br>
		</c:when>
		<c:otherwise>
			안녕하세요<br>
		</c:otherwise>
	</c:choose>
	
	<h3>4. 반복문 - forEach (c:forEach var="" begin="" end="" step="" items="" varStatus="")</h3>
	<pre>
	&lt;c:forEach&gt; 반복 시 실행할 내용 &lt;/c:forEach&gt;
	- Java의 for문에 해당하는 기능을 제공.
	- forEach문은 여러가지 속성이 사용됨
	
	var: 현재 반복 횟수에 해당하는 변수의 이름
	begin: 반복이 시작할 요소 번호(0 ... n)
	end: 반복이 끝나는 요소 번호
	step: 반복 시 증가할 수
	item: 반복할 객체명
	varStatus: 현재 반복에 해당하는 객체의 요소 정보
	</pre>
	
	<h4>기본 사용법</h4>
	<c:forEach var="i" begin="1" end="10">
		반복 확인 : ${ i } <br>
	</c:forEach>
	
	<br>
	
	<c:forEach var="i" begin="1" end="6">
		<h${i}>EL로 반복문 사용</h${i}>
		<!-- 태그 안에서도 적용 가능 -->
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="10" step="2">
		반복 확인: ${ i } <br>
		<!-- step의 속성값은 0보다 작거나 같을 수 없음. -->
	</c:forEach>
	
	<c:forEach var="color" items="${ arr }">
		<font color="${ color }">배열 확인 : ${ color }</font><br>
	</c:forEach>
	
	<hr>
	
	<%
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", 20, '남'));
		list.add(new Person("우별림", 30, '여'));
		list.add(new Person("김개똥", 10, '남'));
		
		pageContext.setAttribute("list", list);
	%>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>순번</th>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
		</tr>
		<c:forEach var="p" items="${ list }" varStatus="status">
		<tr>
			<td>${ status.index }</td>
			<td>${ status.count }</td>
			<td>${ p.name }</td>
			<td>${ p.name }</td>
			<td>${ p.gender }</td>
		</tr>
		</c:forEach>
	</table>
	
	<hr>
	
	<h3>5. forTokens</h3>
	<pre>
	- 문자열에 포함된 구분자를 통해 토큰을 분리해서 반복 처리
	- Java의 String.split() 또는 StringTokenizer와 비슷한 기능
	- items 속성에는 토큰을 포함하는 문자열을 지정하고, delims 속성에는 토큰을 분리하는데
	    사용할 구획문자를 기술
	</pre>
	
	<c:set var="device">
		컴퓨터,핸드폰.TV/에어컨,냉장고.세탁기
	</c:set>
	
	<h4>device</h4>
	<ul>
		<c:forTokens var="d" items="${ device }" delims=",./">
			<li>${ d }</li>
		</c:forTokens>
	</ul>
	
	<ul style="background:black;">
		<c:forTokens var="color" items="yellow pink aqua green red silver olive lime" delims=" ">
			<li style="background-color:${ color };">${ color }</li>
		</c:forTokens>
	</ul>
	
	<hr>
	
	<h3>6. url</h3>
	<pre>
	&lt;c:url&gt;
		&lt;param name="" value=""/&gt;
		&lt;param name="" value=""/&gt;
	&lt;/c:url&gt;
	
	- url 경로를 생성하고, 해당 url의 param 속성을 선언하여 쿼리 스트링을 정의할 수 있는 태그
	- 해당 태그를 통해 url 경로와 관련된 쿼리스트링 값을 미리 설정하여 이를 제어할 수 있음.
	</pre>
	
	<c:url var="url" value="testPage.jsp">
		<c:param name="pName" value="LG그램"/>
		<c:param name="pCount" value="30"/>
		<c:param name="option" value="ssd256G"/>
		<c:param name="option" value="ram16G"/>
	</c:url>
	
	<a href="${ url }">클릭</a>
</body>
</html>