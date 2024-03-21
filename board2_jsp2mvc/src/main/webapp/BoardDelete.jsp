<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "com.ssafy.board.dao.BoardDaoImpl" 
    import = "com.ssafy.board.model.BoardDto"%>
    
<%
int articleno = Integer.parseInt(request.getParameter("articleno"));
int cnt = BoardDaoImpl.getInstance().deleteArticle(articleno);
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
            <mark class="sky">�۾��� ���</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
<% if(cnt != 0) {%>
          <div class="card text-center bg-light">
            <h2 class="fw-bold text-primary pt-3">���� �Ϸ�!!!</h2>
            <div class="card-body">
              <p class="card-text">�ۻ����� �Ϸ�Ǿ����ϴ�.</p>
              <button type="button" id="btn-list" class="btn btn-outline-primary">
                �۸�� ������ �̵�...
              </button>
            </div>
          </div>
<% } else { %>
          <div class="card text-center bg-light">
            <h2 class="fw-bold text-danger pt-3">���� ����T.T</h2>
            <div class="card-body">
              <p class="card-text">
                �ۻ����� ������ �ֽ��ϴ�. <br />
                ��� �� �õ����ּ���.
              </p>
              <button type="button" id="btn-list" class="btn btn-outline-danger">
                �۸�� ������ �̵�...
              </button>
            </div>
          </div>
<% } %>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
    <script>
      document.querySelector("#btn-list").addEventListener("click", function () {
        location.href = "/board2/BoardList.jsp";
      });
    </script>
  </body>
</html>