<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newLine","\n"); %>
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
   <script src="${cpath}/resources/js/update.js"></script>
 <script>
      updateDetail("${num}");
 </script>
</head>
</head>
<body>

<div class="container">
  <h2>Spring Web MVC</h2>
  <div class="card">
    <div class="card-header">BOARD</div>
    <div class="card-body" id="updateForm">
       <!-- 수정화면 -->
    </div>
    <div class="card-footer">클라우드기반 인공지능 서비스 엔지니어링과정(박매일)</div>
  </div>
</div>
</body>
</html>