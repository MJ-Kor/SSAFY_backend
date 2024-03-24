<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   String root = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

	<form id="registForm" method = "post" action="<%=root%>/member">
		<input type="hidden" name="action" value="login">
		<div>
			<label for="id">아이디</label> <input type="text"
				id="id" name ="id" placeholder="아이디 입력">
		</div>
		<div class="form-group">
			<label for="pw"> 패스워드</label> <input type="text" id="pw" name = "password"
				placeholder="비밀번호 입력">
		</div>
		<div class="form-group">
		 <label for="idck"> </label><input type="checkbox" id="idck" name = "idck" value = "ok"> 

		</div>

		<button type="submit" id="regist">등록</button>
		<button type="reset">취소</button>
	</form>

</body>
</html>