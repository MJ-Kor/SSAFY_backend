<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import = "com.ssafy.test.car.model.CarDto"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:set var="car" value="${car}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 상세 페이지</title>
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
	<nav>
	<h1>차량 상세 페이지</h1>
	<jsp:include page="/nav.jsp" />
	</nav>
	<a href="${root}/board?action=list">목록으로</a>
	<table>
		<tr>
			<th>차량 번호</th>
			<td>${car.number}</td>
		</tr>
		<tr>
			<th>모델</th>
			<td>${car.model}</td>

		</tr>
		<tr>
			<th>가격</th>
			<td>${car.price}</td>
		</tr>
		<tr>
			<th>브랜드</th>
			<td>${car.brand}</td>
		</tr>
		<tr>
			<th>차량 크기</th>
			<td>${car.size}</td>
		</tr>
		<tr>
	</table>
	<a href="${root}/board?action=mvmodify&number=${car.number}">수정</a>
	<a href="${root}/board?action=delete&number=${car.number}">삭제</a>
</body>
</html>