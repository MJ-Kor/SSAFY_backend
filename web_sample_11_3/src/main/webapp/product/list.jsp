<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import = "java.util.*"
	import = "ssafy.com.product.model.ProductDto"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
String root = request.getContextPath();
List<ProductDto> products = (List<ProductDto>)request.getAttribute("products");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
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
		<h1>상품 목록 페이지</h1>
	</nav>
	<a href="<%= root %>/index.jsp">메인 페이지</a>
	<br>
	<a href="<%= root %>/board?action=mvadd">등록하기</a>
	<table>
		<thead>
			<tr>
				<th>고유번호</th>
				<th>모델명</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
<% for(ProductDto productDto : products) {%>
		<tr>
			<td><a href = "<%= root%>/board?action=view&code=<%= productDto.getCode()%>"><%= productDto.getCode()%></a></td>
			<td><%= productDto.getModel()%></td>
			<td><%= productDto.getPrice()%></td>
		</tr>
<% } %>
		</tbody>
	</table>
	<form id = "search-form" method="POST" action="">
		<input type="hidden" name="action" value="search">
		<select id="key" name="key">
		<option selected>검색 조건</option>
		<option value="code">고유 번호</option>
		<option value="model">모델 명</option>
		<option value="price">가격</option>
		</select>
		<input name="searchWord" id="searchWord" placeholder="검색어를 입력하세요">
		<button type="button" id="search">검색</button>
	</form>
	<script>
		document.querySelector("#search").addEventListener("click", function(){
			let form = document.querySelector("#search-form");
			form.setAttribute("action", "<%=root%>/board");
			form.submit();
		})
	</script>
</body>
</html>