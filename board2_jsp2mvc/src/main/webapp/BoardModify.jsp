<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.ssafy.board.dao.BoardDaoImpl" 
    import = "com.ssafy.board.model.BoardDto"%>

<%
int articleno = Integer.parseInt(request.getParameter("articleno"));
String userid = request.getParameter("userid");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
BoardDto boardDto = new BoardDto();
boardDto.setUserId(userid);
boardDto.setSubject(subject);
boardDto.setContent(content);
int cnt = BoardDaoImpl.getInstance().updateArticle(articleno, boardDto);
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
            <mark class="sky">글쓰기 결과</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
<% if(cnt != 0) {%>
          <div class="card text-center bg-light">
            <h2 class="fw-bold text-primary pt-3">수정 완료!!!</h2>
            <div class="card-body">
              <p class="card-text">글수정이 완료되었습니다.</p>
              <button type="button" id="btn-list" class="btn btn-outline-primary">
                글목록 페이지 이동...
              </button>
            </div>
          </div>
<% } else { %>
          <div class="card text-center bg-light">
            <h2 class="fw-bold text-danger pt-3">수정 실패T.T</h2>
            <div class="card-body">
              <p class="card-text">
                글수정에 문제가 있습니다. <br />
                잠시 후 시도해주세요.
              </p>
              <button type="button" id="btn-list" class="btn btn-outline-danger">
                글목록 페이지 이동...
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