<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>PreProject</title>
    <link href="/resource/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<form  action="/login_process" method="POST">
    <p>
        <label for="login">Login:</label>
        <input type="text" name="login" id="login">
    </p>
    <p>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password">
    </p>
    <input class="submit" type="submit" value="Login">
</form>

</body>
</html>
