<%--
  Created by IntelliJ IDEA.
  User: zyz
  Date: 2021/7/31
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <%--    引入js--%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    <style type="text/css">
        a{
            text-decoration: none;
        }
    </style>

</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>用户登录</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/customer/login" method="post">

        <div class="form-group">
            <div class="row">
                <div class="col-md-1"><label for="usercount">用户账号 :</label></div>
                <div class="col-md-3">  <input type="text" placeholder="请输入账号" onblur="return checkCount()" class="form-control" name="usercount" id="usercount" ></div>
                <div class="col-md-2"> <span id="tipCount" style="color: red"></span></div>
            </div>
        </div>


        <div class="form-group">
            <div class="row">
                <div class="col-md-1"><label for="name">用户姓名 :</label></div>
                <div class="col-md-3">  <input type="text" placeholder="请输入姓名" onblur="return checkName()" class="form-control" name="name" id="name" ></div>
                <div class="col-md-3"> <span id="tipName"  style="color: red"></span></div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-1">
                <button type="submit" class="btn btn-default" onclick="return checkform()" >登录</button>
            </div>
            <div class="col-md-1">
                <a class="btn btn-default" href="register.jsp"  >注册</a>
            </div>
        </div>




    </form>


</div>

<script type="text/javascript">
    var patt1 = /^[0-9]+.?[0-9]*$/;//正则表达式验证是否为纯数字


    //一级验证账号
    function checkCount(){
        var usercount =$("#usercount").val();

        if (usercount == null || usercount == ''){
            $("#tipCount").text("账号不能为空");
            return false;
        }else if (usercount.match(patt1)!=null){
            $("#tipCount").text("账号不能为纯数字");
            return  false;
        }else if (usercount.length <1 ||usercount.length >8){
            $("#tipCount").text("账号长度1-8");
            return  false;
        }else {
            $("#tipCount").text(" ")
        }

    }

    //一级验证姓名
    function checkName(){
        var name  =$("#name").val();
        if (name == null || name == ''){
            $("#tipName").text("姓名不能为空!!!");
            return false;
        }else if (name.match(patt1)!=null){
            $("#tipName").text("姓名不能纯数字!!!");
            return false;
        }else if (name.length<1 || name.length >6){
            $("#tipName").text("姓名长度1-6!!!");
            return false;
        }else {
            $("#tipName").text(" ");
        }

    }

    //二级验证
    function checkform(){
        var usercount =$("#usercount").val();
        var name  =$("#name").val();

        if (usercount == null || usercount == ''){
            alert("账号不能为空，请输入账号");
            return false;
        }

        if (name == null || name == ''){
            alert("姓名不能为空!!!");
            return false;
        }




    }

</script>
</body>
</html>
