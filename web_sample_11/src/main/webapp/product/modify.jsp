<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import = "com.ssafy.product.model.ProductDto"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
String root = request.getContextPath();
ProductDto productDto = (ProductDto)request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
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
		<h2>상품 정보 수정</h2>
	</nav>

	<form id="modifyForm" method="POST" action="">
		<input type="hidden" name="action" value="modify">
		<div>
			<label for="productCode">고유번호</label> <input type="text"
				id="productCode" placeholder="고유번호 입력" name="productCode" value=<%= productDto.getCode() %> readonly>
		</div>
		<div class="form-group">
			<label for="model">모델명</label> <input type="text" id="model"
				placeholder="모델명 입력" name="model" value=<%= productDto.getModel() %> readonly>
		</div>
		<div class="form-group">
			<label for="price">가격</label> <input type="number" id="price"
				placeholder="가격 입력" name="price" value=<%= productDto.getPrice() %>>
		</div>

		<button type="button" id="modify">등록</button>
		<a href="#">취소</a>
	</form>
	<script>
		document.querySelector("#modify").addEventListener("click", function(){
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
				let form = document.querySelector("#modifyForm");
				form.setAttribute("action", "<%= root %>/board");
				form.submit();
			}
		});
	</script>
</body>
</html>