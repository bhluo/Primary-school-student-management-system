<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Parent_Info</title>
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
</head>
<body>
<h1>Welcome to Event Page</h1>
<h3>At this page, u can check the award/punishment.Of course,as the admin,u are permitted to delete or add Information of the parents.</h3>
<form action="eventServlet" method="post">
    <input type="text" name="id" placeholder="id" required>
    <input type="text" name="date" placeholder="date" required>
    <input type="text" name="type" placeholder="type" required>
    <input type="text" name="detail" placeholder="detail" required>
    <input type="submit" value="添加">
</form>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>date</th>
        <th>type</th>
        <th>detail</th>
        <th>operation</th>
    </tr>
    </thead>
    <tbody>
    <%-- 遍历列表，将数据填充到表格中 --%>
    <c:forEach var="event" items="${events}">
        <tr>
            <td><c:out value="${event.id}"/></td>
            <td><c:out value="${event.event_date}"/></td>
            <td><c:out value="${event.event_type}"/></td>
            <td><c:out value="${event.detail}"/></td>
            <td>
                <a href="eventServlet?action=delete&id=${event.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<button id="welcome-btn" onclick="redirectToWelcome()">Back</button>
<script> function redirectToWelcome() {
    window.location.href = 'welcome.jsp';
}</script>
<div class="con"><p>Copyright 2023-12-19 Luo Bohong</p></div>
</body>
</html>
