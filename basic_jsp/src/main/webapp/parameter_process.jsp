<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1. 이름, 비번, 과일을 get
String name = request.getParameter("username");
String pwd = request.getParameter("userpwd");
String[] fruit = request.getParameterValues("fruit");
//2. logic 처리
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>과일 선호도 조사 jsp</h1>
<%= name %>(<%= pwd %>)님이 좋아하는 과일은
<%
if(fruit != null){
	for (int i = 0; i < fruit.length; i++) {
%>
<%= fruit[i] %>,
<% 
	}
}else {
%>
	없습니다.
<%
}
%>
</body>
</html>