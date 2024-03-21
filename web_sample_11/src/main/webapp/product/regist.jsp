<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
String root = request.getContextPath();
%>
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
	</nav>

	<form id="registForm" method="POST" action="">
		<input type="hidden" name="action" value="write">
		<div>
			<label for="productCode">고유번호</label> <input type="text"
				id="productCode" placeholder="고유번호 입력" name="productCode">
		</div>
		<div class="form-group">
			<label for="model">모델명</label> <input type="text" id="model"
				placeholder="모델명 입력" name="model">
		</div>
		<div class="form-group">
			<label for="price">가격</label> <input type="number" id="price"
				placeholder="가격 입력" name="price">
		</div>

		<button type="button" id="regist">등록</button>
		<a href="#">취소</a>
	</form>
	<script>
		document.querySelector("#regist").addEventListener("click", function(){
			if(!document.querySelector("#productCode").value){
				alert("고유번호 입력!!");
				return;
			} else if (!document.querySelector("#model").value){
				alert("모델명 입력!!");
				return;
			} else if (!document.querySelector("#price").value){
				alert("가격 입력!!");
				return;
			} else {
				let form = document.querySelector("#registForm");
				form.setAttribute("action", "<%= root %>/product");
				form.submit();
			}
		});
	</script>
</body>
</html>