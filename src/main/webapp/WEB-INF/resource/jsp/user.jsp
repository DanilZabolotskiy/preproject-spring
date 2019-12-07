<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User</title>
</head>

<body>

<c:set value="${user}" var="user" />

<div>
    <label><b>Login:</b></label>
    <p>
        ${user.login}
    </p>
</div>

<div>
    <label><b>Role:</b></label>
    <p>
        ${user.roles}
    </p>
</div>

</body>

</html>
