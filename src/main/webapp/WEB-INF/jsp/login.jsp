<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <title>登录</title>
    <!-- Bootstrap -->
    <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <style type="text/css">
        .login-box {
            width: 300px;
            height: 300px;
            border: 1px solid #1a312c;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -150px;
            margin-top: -150px;
            border-radius: 5px;
            padding: 10px;
        }

    </style>
</head>
<body>

<div class="container">
    <%-- 登录 --%>
    <div class="login-box">
        <form action="${ctx}/login/submit" method="post">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" id="username" name="userName" placeholder="输入用户名">
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" name="userPassword" placeholder="输入密码">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="rememberMe" value="true">记住我
                </label>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</div>



<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
