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
    <title>书籍展示页面</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表----------显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row ">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAdd">添加书籍</a>
            &nbsp;&nbsp;
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/queryAll">显示所有书籍</a>
        </div>

        <div class="col-md-4 column" >

        </div>
        <div class="col-md-4 column">
            <form action="${pageContext.request.contextPath}/book/queryBookName" method="post" class="form-inline" style="float: right">
                <span style="color: #ff0000" >${error}</span>
                <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <!--查询书籍处理-->
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>

                        <td>${book.bookId}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>

                            <a href="${pageContext.request.contextPath}/book/todelete?id=${book.bookId}">删除</a>
                            &nbsp;|&nbsp;
                            <a href="${pageContext.request.contextPath}/book/toUpdate?id=${book.bookId}">修改</a>
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


<%--<div class="container">--%>
<%--    <div class="row clearfix">--%>
<%--        <div class="col-md-12 column">--%>
<%--            <div class="page-header">--%>
<%--                <h1>--%>
<%--                    <small>用户信息---------------显示所有的用户信息</small>--%>
<%--                </h1>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


<%--    <div class="row">--%>
<%--        <div class="col-md-4 column">--%>
<%--            <a class="btn btn-primary" >添加用户信息</a>--%>
<%--            &nbsp; &nbsp;--%>

<%--            <a class="btn btn-primary" >显示所有用户信息</a>--%>
<%--        </div>--%>

<%--        <div class="col-md-4 column"></div>--%>

<%--        <div class="col-md-4 column">--%>
<%--            <form class="form-inline">--%>
<%--                <input type="text" class="form-control" placeholder="请输入要查询的用户账号">--%>
<%--                <input type="submit" value="查询" class="btn btn-primary">--%>
<%--            </form>--%>
<%--        </div>--%>

<%--    </div>--%>



<%--    <div class="row clearfix">--%>
<%--        <div class="col-md-12 column">--%>
<%--            <table class="table table-hover table-striped">--%>
<%--                <thead>--%>
<%--                <tr>--%>
<%--                    <th>账号</th>--%>
<%--                    <th>姓名</th>--%>
<%--                    <th>性别</th>--%>
<%--                    <th>年龄</th>--%>
<%--                    <th>电话</th>--%>
<%--                    <th>邮箱</th>--%>
<%--                    <th>地址</th>--%>
<%--                    <th>操作</th>--%>
<%--                </tr>--%>
<%--                </thead>--%>

<%--                <tbody>--%>
<%--                <c:forEach var="customer" items="${list}">--%>
<%--                    <tr>--%>
<%--                        <td>${customer.usercount}</td>--%>
<%--                        <td>${customer.name}</td>--%>
<%--                        <td>${customer.sex}</td>--%>
<%--                        <td>${customer.age}</td>--%>
<%--                        <td>${customer.tel}</td>--%>
<%--                        <td>${customer.email}</td>--%>
<%--                        <td>${customer.address}</td>--%>
<%--                        <td>--%>

<%--                                &lt;%&ndash;                        <a href="${pageContext.request.contextPath}/book/todelete?id=${book.bookId}">删除</a>&ndash;%&gt;--%>
<%--                                &lt;%&ndash;                        <a href="${pageContext.request.contextPath}">修改</a>&ndash;%&gt;--%>
<%--                                &lt;%&ndash;                        &nbsp;&nbsp;|&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/customer/delete?id=${customer.usercount}">删除</a>&ndash;%&gt;--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--                </tbody>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
