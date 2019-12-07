<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Edit User</title>
    <link href="/WEB-INF/resource/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<c:set value="${user}" var="user" />
<c:set value="${rolesNames}" var="rolesNames" />

<form  action="/admin/edit/save" method="POST">
    <input type="hidden" value=${user.id} name="id">
    <p>
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" value=${user.login}>
    </p>
    <p>
        <label for="password">Password:</label>
        <input type="text" name="password" id="password" value=${user.password}>
    </p>
    <p>
        <label>Role:</label><br>
        <input type="checkbox" name="roleAdmin" value="admin"
               <c:if test="${rolesNames.contains('admin')}">checked</c:if>>admin<br>
        <input type="checkbox" name="roleUser" value="user"
               <c:if test="${rolesNames.contains('user')}">checked</c:if>>user<br>
    </p>
    <input class="submit" type="submit" value="Save">
</form>

</body>
</html>
