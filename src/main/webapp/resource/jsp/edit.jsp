<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Edit User</title>
    <link href="/resource/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<c:set value="${user}" var="user" />

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
        <label for="role">Role:</label>
        <select  name="role" id="role">
            <option name="admin">admin</option>
            <option name="user">user</option>
            <option selected>${user.role}</option>
        </select>
    </p>
    <input class="submit" type="submit" value="Save">
</form>

</body>
</html>
