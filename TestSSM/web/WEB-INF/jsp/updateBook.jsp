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
    <title>修改页面</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bookId" value="${QBook.bookId}">

        <div class="form-group">
            <label >书籍名称</label>
            <input type="text" class="form-control" name="bookName" value="${QBook.bookName}" required>
        </div>
        <div class="form-group">
            <label >书籍数量</label>
            <input type="text" class="form-control" name="bookCounts" value="${QBook.bookCounts}" required>
        </div>
        <div class="form-group">
            <label >描述</label>
            <input type="text" class="form-control" name="detail" value="${QBook.detail}" required>
        </div>


        <button type="submit" class="btn btn-default">保存</button>
    </form>
</div>
</body>
</html>
