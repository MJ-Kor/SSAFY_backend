<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import = "java.util.*"
	import = "com.ssafy.test.car.model.CarDto"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:set var="list" value="cars.attribute"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 목록 페이지</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

nav {
display : flex;
justify-content : space-between;
align-items : center
}
nav a {
margin-right: 10px
}
</style>
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.userinfo}">
		<script>
		alert("로그인이 필요합니다.");
		location.href = "${root}/login.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<nav>
			<h1>차량 목록 페이지</h1>
			<jsp:include page="/nav.jsp" />
		</nav>
		<a href="${root}/index.jsp">메인 화면으로</a>
		<a href="${root}/board?action=mvadd">등록하기</a>
		<table>
			<thead>
				<tr>
					<th>차량 번호</th>
					<th>모델</th>
					<th>브랜드</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="car" items="${cars}">
			<tr>
				<td><a href="${root}/board?action=view&number=${car.number}">${car.number}</a></td>
				<td>${car.number}</td>
				<td>${car.number}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>