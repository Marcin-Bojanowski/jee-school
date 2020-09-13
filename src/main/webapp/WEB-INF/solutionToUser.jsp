<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-18
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Solution to user</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h1>User list</h1>
<form action="/solutionToUser" method="post">
    <c:forEach var="user" items="${userList}">
    <p><input type="checkbox" name="id" value="${user.id}">${user.name}</p>
</c:forEach>
    <button type="submit">Save</button>
</form>

</body>
</html>
