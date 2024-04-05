<!DOCTYPE html>
<meta charset="UTF-8">
<html>
<head>
  <title>Welcome</title>
  <style>
    body {
      background-color: #dddfd4;
    }
    .container {
      width: 900px;
      height: 650px;
      margin: 0 auto;
      position: relative;
      top: 20px;
      background-color: #fae596;
      border: 1px solid #ccc;
      padding: 20px;
      border-radius: 8%;
    }
    .module-wrapper {
      display: flex;
      justify-content: space-between;
      align-items: center;
      flex-wrap: wrap;
      margin-top: 30px;
    }
    .module {
      width: 300px;
      height: 120px;
      background-color: #f2f2f2;
      border: 1px solid #ccc;
      margin: 30px;
      margin-bottom: 20px;
      text-align: center;
      line-height: 120px;
      cursor: pointer;
      font-size: 20px;
      color: #333;
      border-radius: 10%;
    }
    h1 {
      font-size: 28px;
      color: #333;
      text-align: center;
      margin-bottom: 20px;
    }
    .h3{
      text-align: center;
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
<div class="container">
  <h1>Welcome to the Elementary School Student Management System</h1>
  <h3>There are 5 modules below.</h3>
  <div class="module-wrapper">
    <div class="module" onclick="gotoAdmin()">Admin Management</div>
    <div class="module" onclick="gotoStudentInfo()">Student Information</div>
    <div class="module" onclick="gotoScore()">Score Management</div>
    <div class="module" onclick="gotoParentInfo()">Parent Information</div>
    <div class="module" onclick="gotoRecord()">Reward/Punishment Management</div>
  </div>
</div>

<script>
  function gotoAdmin() {
    window.location.href = "adminManagement.jsp";
  }

  function gotoStudentInfo() {
    window.location.href = "studentInfo.jsp";
  }

  function gotoScore() {
    window.location.href = "score.jsp";
  }

  function gotoParentInfo() {
    window.location.href = "parentInfo.jsp";
  }

  function gotoRecord() {
    window.location.href = "event.jsp";
  }
</script>
<div class="con"><p>Copyright 2023-12-19 Luo Bohong</p></div>

</body>
</html>
