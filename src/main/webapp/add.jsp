<%--
  Created by IntelliJ IDEA.
  User: Martin
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>

<h1>添加用户</h1>

<form action="/user" method="post">
    编号:<input type="text" name="id"/><br/>
    姓名:<input type="text" name="name"/><br/>
    <input type="hidden" name="method" value="add"/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
