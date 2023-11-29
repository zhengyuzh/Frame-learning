<%--
  Created by IntelliJ IDEA.
  User: zyz
  Date: 2021/9/23
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新用户注册</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <%--    引入js--%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <style type="text/css">

    </style>

</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新用户注册</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/customer/addCustomer" method="post" >

        <div class="form-group">
            <div class="row">
                <div class="col-md-1" ><label for="usercount" >账号 :</label> </div>
                <div class="col-md-3"> <input type="text" placeholder="请输入账号" onblur="return checkCount()"   class="form-control col-md-6 " name="usercount" id="usercount"></div>
                <div class="col-md-2"> <span id="tipCount" style="color: red"></span></div>
            </div>
        </div>

        <div class="form-group">
            <div class="row">
                <div class="col-md-1"><label for="name">姓名 :</label></div>
                <div class="col-md-3">  <input type="text" placeholder="请输入姓名" onblur="return checkName()" class="form-control" name="name" id="name" ></div>
                <div class="col-md-3"> <span id="tipName"  style="color: red"></span></div>
            </div>
        </div>


        <div class="form-group">
            <div class="row">
                <div class="col-md-1"><label for="sex">性别 :</label></div>
                <div class="col-md-3"> <input type="text" placeholder="请输入性别" onblur="return checkSex()"  class="form-control" name="sex" id="sex" ></div>
                <div class="col-md-3"> <span id="tipSex"  style="color: red"></span></div>
            </div>
        </div>

        <div class="form-group">
            <div class="row">
                <div class="col-md-1"> <label for="age">年龄:</label></div>
                <div class="col-md-3"><input name="age" placeholder="请输入年龄" onblur="return checkAge()" class="form-control"  id="age"></input></div>
              <div class="col-md-3"> <span id="tipAge"  style="color: red"></span></div>
            </div>
        </div>


        <div class="form-group">
            <div class="row">
                <div class="col-md-1"><label for="email">邮箱 :</label></div>
                <div class="col-md-3"> <input type="text" placeholder="请输入邮箱" onblur="return checkEmail()" class="form-control" name="email" id="email" ></div>
                <div class="col-md-3"> <span id="tipEmail" style="color: red"></span></div>
            </div>
        </div>

        <div class="form-group">
            <div class="row">
                <div class="col-md-1"><label for="tel">电话 :</label></div>
                <div class="col-md-3"> <input type="text" placeholder="亲输入电话" onblur="return checkTel()"  class="form-control" name="tel" id="tel" ></div>
                <div class="col-md-3"> <span id="tipTel" style="color: red"></span></div>
            </div>
        </div>

        <div class="form-group">
            <div class="row">
                <div class="col-md-1"><label for="address">家庭地址 :</label></div>
                <div class="col-md-3"> <input type="text" placeholder="请输入地址" onblur="return checkAddress()" class="form-control" name="address" id="address" ></div>
                <div class="col-md-4"> <span id="tipAddress" style="color: red"></span></div>
            </div>
        </div>



        <div class="form-group">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-1"> <button type="submit" class="btn btn-default form-control" onclick="return checkform()" >注册</button></div>
                <div class="col-md-1"> <a class="btn btn-default form-control" href="login.jsp"  >登录</a></div>
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

    //一级验证性别
    function checkSex(){
        var sex=$("#sex").val();

        if (sex == null || sex == ''){
            $("#tipSex").text("性别不能为空!!!");
            return false;
        }else if (sex === '男'||sex === '女'){
            $("#tipSex").text("");
        }else{
            $("#tipSex").text("请输入正确的性别：男 / 女");
        }
    }

    //一级验证年龄
    function checkAge(){
        var age=$("#age").val();
        if(age == null || age == ''){
            $("#tipAge").text("输入的年龄不能为空！！！");
            return false;
        }else if (age.match(patt1)==null){
            $("#tipAge").text("输入的年龄不合法！！！");
            return  false;
        }else if (age <0 || age > 150){
            $("#tipAge").text("请输入合法的年龄：0-150岁！！！");
            return false;
        }else{
            $("#tipAge").text(" ");

        }


    }
    //一级验证邮箱
    function checkEmail(){
        var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        var email =$("#email").val();
        if (email == null || email == ''){
            $("#tipEmail").text("输入的邮箱为空！！！");
            return false;
        }else if (email.match(re) == null){
            $("#tipEmail").text("请输入合法的邮箱：例如（zha@qq.com)");
            return false;
        }else{
            $("#tipEmail").text(" ");
        }

    }

    //一级验证手机号
    function checkTel(){
        var re = /^1\d{10}$/;
        var tel= $("#tel").val();
        if (tel == null || tel ==''){
            $("#tipTel").text("输入的手机号为空！！！");
            return false;
        }else if (tel.match(re) == null){
            $("#tipTel").text("输入的手机号不合法！！！");
            return false;
        }else{
            $("#tipTel").text(" ");
        }

    }


    //一级验证地址
    function checkAddress(){
        var address=$("#address").val();
        var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;

        if (address == null || address ==''){
            $("#tipAddress").text("家庭地址不能为空！！！");
            return false;
        }else if (address.match(patt1) != null){
            $("#tipAddress").text("家庭地址不能为纯数字，请输入正确的家庭地址");
            return false;
        }else{
            $("#tipAddress").text(" ");
        }

    }




    //二级验证
    function checkform(){

        var re = /^1\d{10}$/;
        var re1 = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        var usercount =$("#usercount").val();
        var name  =$("#name").val();
        var sex=$("#sex").val();
        var age=$("#age").val();
        var email =$("#email").val();
        var tel= $("#tel").val();
        var address=$("#address").val();

        if (usercount == null || usercount == ''){
            alert("账号不能为空");
            return false;
        }else if (usercount.match(patt1)!=null){
            alert("账号不能为纯数字");
            return  false;
        }else if (usercount.length <1 ||usercount.length >8){
            alert("账号长度1-8");
            return  false;
        }

        if (name == null || name == ''){
            alert("姓名不能为空!!!");
            return false;
        }else if (name.match(patt1)!=null){
            alert("姓名不能纯数字!!!");
            return false;
        }else if (name.length<1 || name.length >6){
            alert("姓名长度1-6!!!");
            return false;
        }

        if (sex == null || sex == ''){
            alert("性别不能为空!!!");
            return false;
        }else if (sex === '男'||sex === '女'){

        }else{
            alert("请输入正确的性别：男 / 女");
            return  false;
        }

        if(age == null || age == ''){
            alert("输入的年龄不能为空！！！");
            return false;
        }else if (age.match(patt1)==null){
            alert("输入的年龄不合法！！！");
            return  false;
        }else if (age <0 || age > 150){
            alert("请输入合法的年龄：0-150岁！！！");
            return false;
        }

        if (email == null || email == ''){
            alert("输入的邮箱为空！！！");
            return false;
        }else if (email.match(re1) == null){
            alert("请输入合法的邮箱：例如（zha@qq.com)");
            return false;
        }

        if (tel == null || tel ==''){
            alert("输入的手机号为空！！！");
            return false;
        }else if (tel.match(re) == null){
            alert("输入的手机号不合法！！！");
            return false;
        }

        if (address == null || address ==''){
            alert("家庭地址不能为空！！！");
            return false;
        }else if (address.match(patt1) != null){
            alert("家庭地址不能为纯数字，请输入正确的家庭地址");
            return false;
        }



    }
</script>



</body>
</html>
