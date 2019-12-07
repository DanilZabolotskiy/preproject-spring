<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>
        Admin panel
    </title>
    <link href="./css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<table class="position">
    <tr class="title">
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${usersFromServer}" var="user">
        <tr class="row">
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.roles}</td>
            <td>
                <form action="/admin/edit" method="POST">
                    <input type="hidden" value=${user.login} name="login">
                    <input class="buttons" type="submit" value="Edit">
                </form>
            </td>
            <td>
                <form action="/admin/delete" method="POST">
                    <input type="hidden" value=${user.id} name="id">
                    <input class="buttons" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="/admin/add">
    <input class="add" type="submit" value="Add">
</form>
</body>
</html>