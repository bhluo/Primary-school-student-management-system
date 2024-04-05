<%@ page contentType="text/html;charset=gb2312" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<style>
body {
background-color: #dddfd4;
}
.con p{
  position:absolute;
  bottom: 0;
  width: 100%;
  text-align: center;
}
</style>
<div align="center">
    <h1>请注册</h1>
    <form action="AddServlet" method="post">
      <table>
        <tr>
          <td>Username：</td>
          <td><input type="text" name="username"></td>
        </tr>
        <tr>
          <td>Password：</td>
          <td><input type="password" name="password"></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </form>
</div>
<script>
  var Null= '<%=request.getParameter("Null")%>';
  if(Null=='yes'){
    alert("用户名和密码不得为空!");
  }
</script>
<div class="con"><p>Copyright 2023-12-19 Luo Bohong</p></div>
</body>
</html>
