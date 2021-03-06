<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%-- Shiro 标签库 --%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <title>首页</title>
    <!-- Bootstrap -->
    <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <div class="container">
        <H3>首页</H3>
        <%-- 游客显示 --%>
        <shiro:guest>
            <dd><a href="${ctx}/login/page" id="login">登录</a></dd>
        </shiro:guest>
        <%-- 用户认证后显示 --%>
        <shiro:user>
            <%-- 学生显示 --%>
            <shiro:hasRole name="student">
                <dd><a href="#">个人中心</a></dd>
            </shiro:hasRole>
            <%-- 管理员显示 --%>
            <shiro:hasRole name="admin">
                <dd><a class="btn btn-default" href="${ctx}/admin/index" id="admin">系统后台</a></dd>
            </shiro:hasRole>
            <dd><a href="${ctx}/login/logout" id="logout">退出登录</a></dd>
        </shiro:user>
        <br>
        <shiro:hasPermission name="admin:*">
            [admin:*]权限可见
        </shiro:hasPermission>

        <shiro:hasRole name="student">
            [student]角色可见
        </shiro:hasRole>
        <br>
        <shiro:hasPermission name="company:list">
            [company:list]权限可见
        </shiro:hasPermission>

    </div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
