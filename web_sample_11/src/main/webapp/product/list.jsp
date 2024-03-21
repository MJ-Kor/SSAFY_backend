<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import = "java.util.*"
	import = "com.ssafy.product.model.ProductDto"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
String root = request.getContextPath();
List<ProductDto> productList = (List<ProductDto>)request.getAttribute("products");
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
	<a href="<%= root%>/index.jsp">메인 페이지</a>
	<br>
	<a href="<%= root%>/product?action=mvwrite">등록하기</a>
	<table>
		<thead>
			<tr>
				<th>고유번호</th>
				<th>모델명</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
		<%
for(ProductDto productDto : productList){
%>
			<tr>
				<td>
					<a
					href="<%= root %>/product?action=view&productCode=<%= productDto.getCode() %>"
	                class="article-title link-dark"
	                data-no="<%= productDto.getCode() %>"
	                style="text-decoration: none"
	                >
	                <%= productDto.getCode() %>
					</a>
				</td>
				<td><%= productDto.getModel() %></td>
				<td><%= productDto.getPrice() %></td>
			</tr>
<% } %>
		</tbody>
	</table>
</body>
</html>