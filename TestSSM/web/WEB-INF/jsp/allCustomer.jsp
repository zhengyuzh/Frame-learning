<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: zyz
  Date: 2021/7/30
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息展示页面</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>



<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>用户信息---------------显示所有的用户信息</small>
                </h1>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" >添加用户信息</a>
            &nbsp; &nbsp;

            <a class="btn btn-primary" >显示所有用户信息</a>
        </div>

        <div class="col-md-4 column"></div>

        <div class="col-md-4 column">
            <form class="form-inline">
                <input type="text" class="form-control" placeholder="请输入要查询的用户账号">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>

    </div>



    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>账号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>电话</th>
                    <th>邮箱</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="customer" items="${list}">
                    <tr>
                        <td>${customer.usercount}</td>
                        <td>${customer.name}</td>
                        <td>${customer.sex}</td>
                        <td>${customer.age}</td>
                        <td>${customer.tel}</td>
                        <td>${customer.email}</td>
                        <td>${customer.address}</td>
                        <td>

                                                        <a href="${pageContext.request.contextPath}/book/todelete?id=${book.bookId}">删除</a>
                                                        <a href="${pageContext.request.contextPath}">修改</a>
                                                        &nbsp;&nbsp;|&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/customer/delete?id=${customer.usercount}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>

