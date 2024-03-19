<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SSAFY ���� ����</title>
</head>
<body>
  <h1>SSAFY ���� ����</h1>
    <form id="form-register" action="" method="post">
      <fieldset>
        <legend >���� ���</legend>
        <label style="display: block;" for="isbn">������ȣ <input type="text" id="isbn" name="isbn"></label>
        <label style="display: block;" for="name">������ <input type="text" id="bname" name="bname"></label>
        <label style="display: block;" for="isbn">���� <input type="text" id="author" name="author"></label>
        <label style="display: block;" for="isbn">���� <input type="text" id="price" name="price"></label>
        <div>
          <label for="isbn">���� </label>
          <input style="display: block;" type="text" id="desc" name="desc" width="100%">
        </div>
        <button type="submit" id="btn-submit">���</button>
        <button type="button">���</button>
      </fieldset>
    </form>
    <script>
    document.querySelector("#btn-submit").addEventListener("click", function () {
        if (!document.querySelector("#isbn").value) {
          alert("������ȣ �Է�!!");
          return;
        } else if (!document.querySelector("#bname").value) {
          alert("������ �Է�!!");
          return;
        } else if (!document.querySelector("#author").value) {
            alert("���� �Է�!!");
            return;
        } else if (!document.querySelector("#price").value) {
            alert("���� �Է�!!");
            return;
        } else if (!document.querySelector("#desc").value) {
            alert("���� �Է�!!");
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