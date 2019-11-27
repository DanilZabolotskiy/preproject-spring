<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Add User</title>
    <link href="/resource/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<form  action="/admin/add" method="POST">
    <p>
        <label for="login">Login:</label>
        <input type="text" name="login" id="login">
    </p>
    <p>
        <label for="password">Password:</label>
        <input type="text" name="password" id="password">
    </p>
    <p>
        <label for="role">Role:</label>
        <select  name="role" id="role">
            <option name="admin">admin</option>
            <option name="user">user</option>
        </select>
    </p>
    <input class="submit" type="submit" value="Add">
</form>
</body>
</html>
