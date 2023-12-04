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
    <title>添加书籍</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<%--    引入js--%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加书籍</small>
                </h1>
            </div>
        </div>
    </div>
<form action="${pageContext.request.contextPath}/book/addBook" method="post">

    <div class="form-group">
        <div class="row">
            <div class="col-md-1" ><label for="bookId" >书籍编号 :</label> </div>
            <div class="col-md-3"> <input type="text"   class="form-control col-md-6 " name="bookId" id="bookId" onblur=" return checkID()">  </div>
            <div class="col-md-2"> <span id="tipId" style="color: red"></span></div>
        </div>
    </div>

    <div class="form-group">
        <div class="row">
            <div class="col-md-1"><label for="bookName">书籍名称 :</label></div>
            <div class="col-md-3">  <input type="text" class="form-control" name="bookName" id="bookName" onblur="return checkName()"></div>
            <div class="col-md-2"> <span id="tipName" style="color: red"></span></div>
        </div>
    </div>


    <div class="form-group">
        <div class="row">
            <div class="col-md-1"><label for="bookCounts">书籍数量 :</label></div>
            <div class="col-md-3"> <input type="text" class="form-control" name="bookCounts" id="bookCounts" onblur="return checkCount()"></div>
            <div class="col-md-2"> <span id="tipCount" style="color: red"></span></div>
        </div>
    </div>

    <div class="form-group">
        <div class="row">
            <div class="col-md-1"> <label for="detail">描述 :</label></div>
            <div class="col-md-3"><textarea name="detail"  class="form-control" rows="3" cols="4"  id="detail" onblur="return checkDeatil()"  ></textarea></div>
            <div class="col-md-2"> <span id="tipDetail" style="color: red"></span></div>
        </div>
    </div>


    <button type="submit" class="btn btn-default" onclick=" return checkform()">添加</button>
</form>
<script type="text/javascript">

    // 一级验证

    // 验证书籍id
    function checkID(){
        var id = $("#bookId").val();
        var patt1 = /^[0-9]+.?[0-9]*$/;//正则表达式验证是否为纯数字

        if (id == null || id ==''){
            $("#tipId").text("书籍编号为空");
            return false;
        }else if(id.match(patt1) ==null){
            $("#tipId").text("书籍编号整数排列");
            return false;

        }else if(id <0 || id>100){
            $("#tipId").text("书籍编号范围1-100");
            return false;

        }else{
            $("#tipId").text(" ");
        }



    }

    //验证书籍名称
    function checkName(){
        var name = $("#bookName").val();
        var patt1 = /^[0-9]+.?[0-9]*$/;//正则表达式验证是否为纯数字

        if (name == null || name ==''){
            $("#tipName").text("书籍名称为空");
            return false;
        }else if (name.match(patt1) != null){
            $("#tipName").text("书籍名称不能为纯数字");

        }else if (name.length <= 0 || name.length >=15){
            $("#tipName").text("书籍名称的长度为1-15");
            return false;
        }else{
            $("#tipName").text(" ");
        }

    }

    //验证书籍数量
    function checkCount(){
        var count=$("#bookCounts").val();
        var patt1 = /^[0-9]+.?[0-9]*$/;//正则表达式验证是否为纯数字

        if (count == null || count == ''){
            $("#tipCount").text("书籍数量不能为空");
            return false;
        }else if(count.match(patt1) == null){
            $("#tipCount").text("请输入正确的书籍数量");
            return false;

        }else if (count <1 || count >50){
            $("#tipCount").text("请输入正确的书籍数量1-50");
            return false;

        }else{
            $("#tipCount").text(" ");
        }


    }

    //验证书籍描述
    function checkDeatil(){
        var detail = $("#detail").val();
        var patt1 = /^[0-9]+.?[0-9]*$/;//正则表达式验证是否为纯数字

        if (detail == null || detail == ''){
            $("#tipDetail").text(" 书籍描述为空");
            return false;
        }else if (detail.match(patt1)!=null){
            $("#tipDetail").text(" 书籍描述不能是纯数字");
            return false;

        }else{
            $("#tipDetail").text(" ");
        }
    }

    // 二级验证

    function checkform(){
        var id = $("#bookId").val();
        var name = $("#bookName").val();
        var count=$("#bookCounts").val();
        var detail = $("#detail").val();

        //验证编号
        if (id == null || id ==''){
            alert("书籍编号为空");
            return false;
        }

        //验证名称
        if (name == null || name ==''){
            alert("书籍名称为空");
            return false;
        }

        //验证数量
        if (count == null || count == ''){
            alert("书籍数量不能为空");
            return false;
        }

        //验证描述
        if (detail == null || detail == ''){
            alert(" 书籍描述为空");
            return false;
        }




    }





</script>


</div>
</body>
</html>
