<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "com.ssafy.board.dao.BoardDaoImpl" 
    import = "com.ssafy.board.model.BoardDto"
   	import = "java.util.*" %>
<%
List<BoardDto> list = (List<BoardDto>)request.getAttribute("articles");
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    <link href="../assets/css/app.css" rel="stylesheet" />
    <title>SSAFY</title>
  </head>
  <body>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">�۸��</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <div class="row align-self-center mb-2">
            <div class="col-md-2 text-start">
              <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">
                �۾���
              </button>
            </div>
            <div class="col-md-7 offset-3">
              <form class="d-flex">
                <select
                  id="key"
                  class="form-select form-select-sm ms-5 me-1 w-50"
                  aria-label="�˻�����"
                >
                  <option selected>�˻�����</option>
                  <option value="articleno">�۹�ȣ</option>
                  <option value="subject">����</option>
                  <option value="userid">�ۼ���</option>
                </select>
                <div class="input-group input-group-sm">
                  <input type="text" class="form-control" placeholder="�˻���..." />
                  <button class="btn btn-dark" type="button">�˻�</button>
                </div>
              </form>
            </div>
          </div>
          <table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">�۹�ȣ</th>
                <th scope="col">����</th>
                <th scope="col">�ۼ���</th>
                <th scope="col">��ȸ��</th>
                <th scope="col">�ۼ���</th>
              </tr>
            </thead>
<%
for (BoardDto boardDto : list) {
%>
            <tbody>
              <tr class="text-center">
                <th scope="row"><%= boardDto.getArticleNo() %></th>
                <td class="text-start">
                  <a
                    href="#"
                    class="article-title link-dark"
                    data-no=<%= boardDto.getArticleNo() %>
                    style="text-decoration: none"
                  >
                    <%= boardDto.getSubject() %>
                  </a>
                </td>
                <td><%= boardDto.getUserId() %></td>
                <td><%= boardDto.getHit() %></td>
                <td><%= boardDto.getRegisterTime() %></td>
              </tr>
<% } %>
            </tbody>
          </table>
        </div>
        <div class="row">
          <ul class="pagination justify-content-center">
            <li class="page-item">
              <a class="page-link" href="#">����</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item active">
              <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">����</a></li>
          </ul>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
    <script>
      let titles = document.querySelectorAll(".article-title");
      titles.forEach(function (title) {
        title.addEventListener("click", function () {
        	let articleno = this.getAttribute("data-no");
        	location.href = "/board2/BoardView.jsp?articleno=" + articleno;
        });
      });

      document.querySelector("#btn-mv-register").addEventListener("click", function () {
        location.href = "/board2/board/write.html";
      });
    </script>
  </body>
</html>
