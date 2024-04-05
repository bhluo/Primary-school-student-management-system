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
<h1>Welcome to ParentInfo Page</h1>
<h3>At this page, u can delete or add Information of the parents.</h3>
<form action="parentServlet" method="post">
    <input type="text" name="id" placeholder="id" required>
    <input type="text" name="parent_name" placeholder="parent_name" required>
    <input type="text" name="relationship" placeholder="relationship" required>
    <input type="text" name="phone" placeholder="phone" required>
    <input type="submit" value="Add">
</form>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Parent's name</th>
        <th>Relationship</th>
        <th>Contact Number</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <%-- 遍历列表，将数据填充到表格中 --%>
    <c:forEach var="parent" items="${Parents}">
        <tr>
            <td><c:out value="${parent.id}"/></td>
            <td><c:out value="${parent.parent_name}"/></td>
            <td><c:out value="${parent.relationship}"/></td>
            <td><c:out value="${parent.phone}"/></td>
            <td>
                <a href="parentServlet?action=delete&id=${parent.id}">Delete</a>
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
