<%--
  Created by IntelliJ IDEA.
  User: zyz
  Date: 2021/7/30
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

      <style type="text/css">
          a{
              text-decoration: none;
              color: black;
              font-size: 18px;
          }
          h3{

              width: 180px;
              height: 38px;
              margin:100px auto;
              text-align: center;
              line-height: 38px;
              background: deepskyblue;
              border-radius: 5px;

          }
      </style>


  </head>
  <body>
 <h3>
   <a href="${pageContext.request.contextPath}/book/queryAll">进入书籍页面</a>
 </h3>

 <h3>
     <a href="${pageContext.request.contextPath}/customer/allcustomer">用户信息页面</a>
 </h3>

  </body>
</html>
