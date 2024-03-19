<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.Date, java.sql.*"
%>
<%!
String name = "김민주";
Date date = new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello SSAFY JSP !!!</h1>
<h1>안녕 싸피 제이에스피 !!!</h1>
<h3><% out.print(name + "님 안녕하세요."); %></h3>
<h3><%= name %>님 안녕하세요.</h3>
<div>오늘은 <%= date %></div>
</body>
</html>