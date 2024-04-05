<%--
  Created by IntelliJ IDEA.
  User: luobohong
  Date: 17/12/2023
  Time: 下午 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome to the Page of Admin Management.</h1>
<style>
    /* 添加表格样式 */
    body {
        background-color: #dddfd4;
    }
    table {
        border-collapse: collapse;
        margin: 20px auto;
    }
    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }
    #welcome-btn {
        position: absolute;
        width:130px;
        height:80px;
        top: 50px;
        right: 50px;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    .con p{
        position:absolute;
        bottom: 0;
        width: 100%;
        text-align: center;
    }
</style>
<!-- 显示管理员列表 -->
<form action="adminManagementServlet" method="post">
    <input type="text" name="username" placeholder="Admin Name" required>
    <input type="text" name="password" placeholder="Password" required>
    <input type="submit" value="Add">
</form>
<table>
    <thead>
    <tr>
        <th>Admin Name</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="admin" items="${admins}">
        <tr>
            <td>${admin.username}</td>
            <td>
                <a href="adminManagementServlet?action=delete&username=${admin.username}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- 添加管理员表单 -->

<button id="welcome-btn" onclick="redirectToWelcome()">Back</button>
<script> function redirectToWelcome() {
    window.location.href = 'welcome.jsp';
}</script>
<div class="con"><p>Copyright 2023-12-19 Luo Bohong</p></div>
</body>
</html>
