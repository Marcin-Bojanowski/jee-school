<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-24
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add solution</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h1>Add solution</h1>
<p>Exercise: <c:out value="${exercise.title}"></c:out></p>
<p>Exercise desrcription: <c:out value="${exercise.description}"></c:out></p>
<form action="/addSolution" method="post">
    <p>Solution:</p>
    <textarea name="description" rows="4" cols="50"></textarea>
    <button type="submit">Save</button>
</form>
</body>
</html>
