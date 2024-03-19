<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SSAFY 도서 관리</title>
</head>
<body>
  <h1>SSAFY 도서 관리</h1>
    <form id="form-register" action="" method="post">
      <fieldset>
        <legend >도서 등록</legend>
        <label style="display: block;" for="isbn">도서번호 <input type="text" id="isbn" name="isbn"></label>
        <label style="display: block;" for="name">도서명 <input type="text" id="bname" name="bname"></label>
        <label style="display: block;" for="isbn">저자 <input type="text" id="author" name="author"></label>
        <label style="display: block;" for="isbn">가격 <input type="text" id="price" name="price"></label>
        <div>
          <label for="isbn">설명 </label>
          <input style="display: block;" type="text" id="desc" name="desc" width="100%">
        </div>
        <button type="submit" id="btn-submit">등록</button>
        <button type="button">취소</button>
      </fieldset>
    </form>
    <script>
    document.querySelector("#btn-submit").addEventListener("click", function () {
        if (!document.querySelector("#isbn").value) {
          alert("도서번호 입력!!");
          return;
        } else if (!document.querySelector("#bname").value) {
          alert("도서명 입력!!");
          return;
        } else if (!document.querySelector("#author").value) {
            alert("저자 입력!!");
            return;
        } else if (!document.querySelector("#price").value) {
            alert("가격 입력!!");
            return;
        } else if (!document.querySelector("#desc").value) {
            alert("설명 입력!!");
            return;
        } else {
          let form = document.querySelector("#form-register");
          form.setAttribute("action", "/book_jsp/main?action=regist");
          form.submit();
        }
      });
    </script>
</body>
</html>