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
        .con p{
            position:absolute;
            bottom: 0;
            width: 100%;
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
    </style>
</head>
<body>
<h1>Welcome to Page of Score</h1>
<h3>At this page, u can delete or add Information of the scores.</h3>
<form action="scoreServlet" method="post">
    <input type="text" name="id" placeholder="id" required>
    <input type="text" name="term" placeholder="term" required>
    <input type="text" name="chinese" placeholder="chinese" required>
    <input type="text" name="math" placeholder="math" required>
    <input type="text" name="english" placeholder="egnlish" required>
    <input type="submit" value="Add">
</form>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>term</th>
        <th>chinese</th>
        <th>math</th>
        <th>english</th>
        <th>operation</th>
    </tr>
    </thead>
    <tbody>
    <%-- 遍历列表，将数据填充到表格中 --%>
    <c:forEach var="score" items="${Scores}">
        <tr>
            <td><c:out value="${score.id}"/></td>
            <td><c:out value="${score.term}"/></td>
            <td><c:out value="${score.chinese}"/></td>
            <td><c:out value="${score.math}"/></td>
            <td><c:out value="${score.english}"/></td>
            <td>
                <a href="scoreServlet?action=delete&id=${score.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script> function redirectToWelcome() {
    window.location.href = 'welcome.jsp';
}</script>
<button id="welcome-btn" onclick="redirectToWelcome()">Back</button>
<div class="con"><p>Copyright 2023-12-19 Luo Bohong</p></div>
</body>
</html>
