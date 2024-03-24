<%@page import="com.ssafy.sample.model.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%
	MemberDto member = (MemberDto) session.getAttribute("userinfo");
	
	%>
	   <%
   String cont = request.getContextPath();%>
   <%if(member == null){ %>
		<a href="<%=cont%>/member?action=mvLogin">로그인</a>
		<%} else{ %>
		<div>
			<span> <%=member.getUserName() %>님 로그인 중</span> 
			<a href="<%=cont%>/member?action=logout">로그아웃</a>
		</div>
		<%} %>
