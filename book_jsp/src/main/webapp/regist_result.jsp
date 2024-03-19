<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String action = request.getParameter("action");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
table, td, th {
  border : 1px solid black;
  border-collapse : collapse;
};
</style>
  <h1>도서 등록 결과</h1>
<%
if(action != null){
%>
  <h3>등록 도서 정보</h3>
  <table>
    <thead>
      <tr>
        <th>항목</th>
        <th>내용</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>도서번호</td>
        <td><%= request.getAttribute("isbn") %></td>
      </tr>
      <tr>
        <td>도서명</td>
        <td><%= request.getAttribute("bname") %></td>
      </tr>
      <tr>
        <td>저자</td>
        <td><%= request.getAttribute("author") %></td>
      </tr>
      <tr>
        <td>가격</td>
        <td><%= request.getAttribute("price") %></td>
      </tr>
      <tr>
        <td>설명</td>
        <td><%= request.getAttribute("desc") %></td>
      </tr>
   </tbody>
  </table>
  <a href="/book_jsp/regist.jsp">추가등록</a>
<% } else {%>
	<span>등록된 도서 정보가 없습니다.<br></span>	
 	<a href="/book_jsp/regist.jsp">추가등록</a>
<% } %>
</body>
</html>