<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.ssafy.test.car.model.CarDto"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:set var="car" value="${car}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 수정</title>
<style>
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
		<h1>차량 수정 페이지</h1>
		<jsp:include page="/nav.jsp" />
	</nav>
	<form action="${root}/board" method="POST">
		<fieldset>
			<input type="hidden" name="action" value="modify">
			<label> 차 번호 <input type="text" name="number" value="${car.number}" readonly></label> 
			<br> 
			<label> 모델 <input type="text" name="model" value="${car.model}"></label> 
			<br>
			<label> 가격 <input type="number" name="price" value="${car.price}"></label> 
			<br> 
			<label> 브랜드 <input type="text" name="brand" value="${car.brand}"></label> 
			<br> 
			<label> 차량 크기 
				<select name="size">
					<option value="소형">소형</option>
					<option value="중형">중형</option>
					<option value="대형">대형</option>
			</select>
			</label> <br> <input type="submit" value="수정"> <br> <a
				href="${root}/board?action=view&number=${car.number}">상세 페이지</a>
		</fieldset>
	</form>
</body>
</html>