<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="${cpath}/resources/js/boardList.js"></script>
  <script>
       boardList(); // javascript 호출
  </script>
</head>
<body>

<div class="container">
  <h2>Spring Web MVC</h2>
  <div class="card">
    <div class="card-header">BOARD</div>
    <div class="card-body">
        <table id="boardList" class="table table-hover table-bordered">
            <thead>
              <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
              </tr>
            </thead>
            <tbody>
             <!-- 여기에 게시판 리스트를 출력(JS) -->
            </tbody>
          </table>
          <button class="btn btn-primary btn-sm" onClick="location.href='${cpath}/register'">글쓰기</button>
    </div>
    <div class="card-footer">클라우드기반 인공지능 서비스 엔지니어링과정(박매일)</div>
  </div>
</div>

</body>
</html>