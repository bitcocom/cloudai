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
  <script src="${cpath}/resources/js/register.js"></script>
</head>
<body>

<div class="container">
  <h2>Spring Web MVC</h2>
  <div class="card">
    <div class="card-header">BOARD</div>
    <div class="card-body">
       <form>
         <div class="form-group">
           <label for="title">제목:</label>
           <input type="text" class="form-control" placeholder="Enter title" id="title" name="title">
         </div>
         <div class="form-group">
           <label for="content">내용:</label>
          <textarea rows="10" class="form-control" id="content" name="content"></textarea>
         </div>
          <div class="form-group">
            <label for="title">작성자:</label>
            <input type="text" class="form-control" placeholder="Enter  writer" id="writer" name="writer">
           </div>
         <button type="button" class="btn btn-primary btn-sm" onclick="goRegister()">등록</button>
         <button type="reset" class="btn btn-danger btn-sm">취소</button>
       </form>
    </div>
    <div class="card-footer">클라우드기반 인공지능 서비스 엔지니어링과정(박매일)</div>
  </div>
</div>

</body>
</html>