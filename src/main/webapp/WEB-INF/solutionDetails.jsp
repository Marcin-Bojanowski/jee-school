<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-16
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Solution details</title>
</head>
<body>
<p>Exercise: <c:out value="${exercise.title}"></c:out></p>
<p>Exercise desrcription: <c:out value="${exercise.description}"></c:out></p>
<p>Added by: <c:out value="${users.name}"></c:out></p>
<p>Email: <c:out value="${users.email}"></c:out></p>
<p>Creation date: <c:out value="${solutions.created}"></c:out></p>
<p>Update date: <c:out value="${solutions.updated}"></c:out></p>
<p>Solution: <c:out value="${solutions.description}"></c:out></p>
</body>
</html>
