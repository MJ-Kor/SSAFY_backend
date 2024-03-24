<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
System.out.println(session.getAttribute("userinfo"));
if(session.getAttribute("userinfo") != null){
%>
	<div>
		<span> 님 로그인 중</span> 
		<a href="<%=root%>/member?action=logout">로그아웃</a>
	</div>
<%
} else {
%>
	<script>
	alert("로그인이 필요한 페이지입니다.");
	location.href = "<%= root %>/member?action=mvlogin";
	</script>
<%
}
%>
