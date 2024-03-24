<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.ssafy.product.model.ProductDto" %>
<%
String root = request.getContextPath();
ProductDto productDto = (ProductDto)request.getAttribute("product");
System.out.println(productDto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<span>고유 코드: </span>
<span><%= productDto.getCode() %></span>
</div>
<div>
<span>모델명: </span>
<span><%= productDto.getModel() %></span>
</div>
<div>
<span>가격: </span>
<span><%= productDto.getPrice() %></span>
</div>
<button type="button" id="list">목록</button>
<button type="button" id="modify">수정</button>
<button type="button" id="delete">삭제</button>
<script>
	document.querySelector("#delete").addEventListener("click", function(){
		location.href = "<%= root %>/board?action=delete&code=<%=productDto.getCode()%>";
	})
	document.querySelector("#modify").addEventListener("click", function(){
		location.href = "<%= root %>/board?action=mvmodify&code=<%=productDto.getCode()%>";
	})
	document.querySelector("#list").addEventListener("click", function(){
		location.href = "<%= root %>/board?action=list";
	})
</script>
</body>
</html>