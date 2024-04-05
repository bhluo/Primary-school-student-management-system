<%--
  Created by IntelliJ IDEA.
  User: luobohong
  Date: 17/12/2023
  Time: 下午 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome to StudentInfo Page</h1>
<h3>At this page, u can delete or add Information of Students.</h3>
<style>
  body {
    background-color: #dddfd4;
  }
  /* 添加表格样式 */
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
<form action="stumServlet" method="post">
  <input type="text" name="id" placeholder="Stu Number" required>
  <input type="text" name="name" placeholder="Full Name" required>
  <input type="text" name="birthdate" placeholder="Birthdate" required>
  <input type="text" name="idCard" placeholder="Id Card" required>
  <input type="submit" value="Add">
</form>
<!-- 显示学生信息列表 -->
<table>
  <thead>
  <tr>
    <th>Stu Number</th>
    <th>Full Name</th>
    <th>Birthdate</th>
    <th>Id Card</th>
    <th>Operation</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="student" items="${students}">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.birthdate}</td>
      <td>${student.idCard}</td>
      <td>
        <a href="stumServlet?action=delete&username=${student.name}">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<!-- 添加学生信息表单 -->
<button id="welcome-btn" onclick="redirectToWelcome()">Back</button>
<div class="con"><p>Copyright 2023-12-19 Luo Bohong</p></div>
</body>
</html>
