<%@ page contentType="text/html;charset=gb2312" %>
<html>
<head>
  <title>Login</title>
  <style>
    body {
      background-color: #dddfd4;
    }
    #login-container {
      background-color: #CCCCCC;
      width: 600px;
      height: 300px;
      padding: 50px;
      margin: 50px auto;
      border-radius: 10px;
    }
    #time {
      position: absolute;
      top: 10px;
      right: 10px;
      font-size: 50px;
    }
    #input{
      margin-left: auto;
      margin-right: auto;
      margin-top: 50px;
      margin-bottom: 100px;
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

<div id="login-container">
  <h1 style="text-align: center;">Сѧ������ϵͳ����Ա��¼</h1>
  <form action="loginServlet" method="post">
    <table id="input">
      <tr>
        <td>�û�����</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>�� �룺</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td></td>
        <td colspan="2" style="text-align: center;">
          <br>
          <input type="submit" value="�ύ">
          <button onclick="window.location.href='register.jsp'">ע��</button>
        </td>
      </tr>
    </table>
  </form>
</div>

<div id="time"></div> <!-- Placeholder for the time -->

<script>
  function updateTime() {
    var now = new Date();
    var formattedTime = now.toLocaleTimeString();
    document.getElementById('time').innerHTML = '��ǰʱ�䣺' + formattedTime;
  }
  updateTime();
  setInterval(updateTime, 1000); // Update time every second
</script>
<div class="con"><p>Copyright 2023-12-19 Luo Bohong</p></div>
</body>
</html>
