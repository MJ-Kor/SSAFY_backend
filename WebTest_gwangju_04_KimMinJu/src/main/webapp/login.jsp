<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:set var="id" value="${cookie.id.value}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
		<h1>로그인 페이지</h1>
	</nav>
	<form action="${root}/user" method="post">
		<fieldset>
			<input type="hidden" name="action" value="login">
			<label> 아이디 <input type="text" name="id" value="${id}"></label> 
			<br> 
			<label> 비밀번호 <input type="password" name="password"></label> <br>
			<div>
			<label>
			    <input type="checkbox" name="remember" value="ok" 
			    <c:if test="${fn:length(id) > 0}">
			        checked
			    </c:if>
			    > 아이디 기억하기
			</label>
			</div>
			<input type="submit" value="로그인"> <br> <a href="${root}/index.jsp">메인
				화면으로</a>
		</fieldset>
	</form>
</body>
</html>