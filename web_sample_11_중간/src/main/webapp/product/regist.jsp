<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
   <%
   String root = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<style>
nav {
	display: flex;
	justify-content: space-between;
	align-items: center
}

nav a {
	margin-right: 10px
}
</style>
</head>
<body>
	<nav>
		<h2>상품 정보 등록</h2>
				<%@ include file ="/nav.jsp" %>
	</nav>

	<form id="registForm" method = "post" action="<%=root%>/product">
		<input type="hidden" name="action" value="insert">
		<div>
			<label for="productCode">고유번호</label> <input type="text"
				id="productCode" name ="productCode" placeholder="고유번호 입력">
		</div>
		<div class="form-group">
			<label for="model">모델명</label> <input type="text" id="model" name="model"
				placeholder="모델명 입력">
		</div>
		<div class="form-group">
			<label for="price">가격</label> <input type="number" id="price" name = "price"
				placeholder="가격 입력">
		</div>

		<button type="submit" id="regist">등록</button>
		<a href="#">취소</a>
	</form>
</body>
</html>