<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ssafy.member.model.MemberDto"%>
	<%
// 만약에 여기서 root 따오면 변수 중복 에러 남
MemberDto userInfo = (MemberDto) session.getAttribute("userinfo");
if(userInfo != null) {
%>
	<div>
		<span> <%= userInfo.getUserName() %>님 로그인 중</span> 
		<a href="<%= root %>/user?action=logout">로그아웃</a>
	</div>
<%	
}
%>