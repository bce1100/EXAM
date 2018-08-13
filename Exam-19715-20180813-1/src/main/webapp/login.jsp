<%--
  Created by IntelliJ IDEA.
  User: bce1100
  Date: 2018/8/13
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登陆页面</title>
    <script src="jquery/jquery.js"></script>
    <link rel="stylesheet"
          href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script
            src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-4 col-md-3" style="margin-top: 50px">
            <span>电影租赁系统</span>
            <form id="loginForm"  action="login" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" id="first_name" name="first_name"
                           placeholder="first_name">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary" id="login">登录</button>
                </div>
                <c:if test="${flag=='login_error'}">
                    <div class="alert alert-warning" role="alert">用户名错误</div>
                </c:if>
            </form>
        </div>
    </div>
</div>
</body>
</html>
