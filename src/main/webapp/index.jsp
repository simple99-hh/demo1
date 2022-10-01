<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户展示</title>
</head>
<body>

<h1>所有用户</h1>

<div ><a href="/user?method=add">添加用户</a></div>
<div ><a href="/user?method=find">查找用户</a></div>
</br>

<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>操作</th>
    </tr>

<%--    <a>${list}</a>--%>

    <c:forEach items = "${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>
                <a href="/user?method=findById&id=${user.id}">修改</a>
                <a href="/user?method=delete&id=${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>