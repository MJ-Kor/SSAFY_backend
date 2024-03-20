<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SSAFY</title>
  </head>
  <body>
    <div align="center">
      <h3>SSAFY 게시판 - MVC</h3>
      <a href="<%= root %>/article?action=mvwrite">글쓰기</a><br />
      <a href="<%= root %>/article?action=list">글목록</a>
    </div>
  </body>
</html>