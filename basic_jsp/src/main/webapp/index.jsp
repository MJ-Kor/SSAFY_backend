<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP</h1>
    <a href="<%= root %>/ssafy.jsp">Hello SSAFY</a>
    <a href="<%= root %>/parameter.jsp">Parameter Test</a>
</body>
</html>