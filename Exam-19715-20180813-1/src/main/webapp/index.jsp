<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <script src="jquery/jquery.js"></script>
    <link rel="stylesheet"
          href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script
            src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<br>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <h2>首页</h2>
            <c:if test="${flag!='login_success'}">
                <button type="button" class="btn btn-default">
                    <a href="login.jsp">点我登陆</a>
                </button>
            </c:if>
            <br>
            <c:if test="${flag=='login_error'}">
                <div class="alert alert-warning" role="alert">用户名错误</div>
            </c:if>
            <c:if test="${flag==null}">
                <div class="alert alert-danger" role="alert">尚未登陆</div>
            </c:if>
            <br>
            <button type="button" class="btn btn-default">
                <a href="list">电影列表</a>
            </button>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
