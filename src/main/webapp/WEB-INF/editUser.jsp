<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-17
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit user</title>

</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>

<h1>Edit user</h1>

<form action="/editUser" method="post">
    <p>Name</p>
    <input type="text" name="name" />
    <p>Email</p>
    <input type="text" name="email"/>
    <p>Password</p>
    <input type="text" name="password"/>
    <p>Group</p>
    <select name="group" >
        <option value="">Select...</option>
        <c:forEach var="group" items="${group}">
            <option value="${group.id}">${group.name}</option>
        </c:forEach>


    </select>
    <button type="submit">Save</button>
</form>
</body>
</html>
