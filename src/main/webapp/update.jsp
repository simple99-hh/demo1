<%--
  Created by IntelliJ IDEA.
  User: Martin
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>

<h1>修改用户</h1>

<form action="/user" method="post">
    编号: <input type="text" name="id" value="${user.id}" readonly/><br/>
    姓名：<input type="text" name="name" value="${user.name}"/><br/>
    <input type="hidden" name="method" value="update"/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
