<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import = "com.ssafy.test.member.model.MemberDto" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="user" value="${sessionScope.userinfo}" />
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<c:choose>
	<c:when test="${empty user}">
		<a href="${root}/user?action=mvlogin">로그인</a>
	</c:when>
	<c:otherwise>
		<div>
			<span>${user.name}님 로그인 중</span> 
			<a href="${root}/user?action=logout">로그아웃</a>
		</div>
	</c:otherwise>
</c:choose>
