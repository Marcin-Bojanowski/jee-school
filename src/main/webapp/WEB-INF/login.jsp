<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-24
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h1>Login</h1>

<form action="/userPanel" method="post">
    <p>Email</p>
    <input type="text" name="email"/>
    <p>Password</p>
    <input type="text" name="password"/>
    </select>
    <button type="submit">Login</button>
</form>
</body>
</html>
