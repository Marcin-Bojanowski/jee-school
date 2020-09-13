<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-18
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add exercise</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h1>Add exercise</h1>

<form action="/addExercise" method="post">
    <p>Title</p>
    <input type="text" name="title"/>
    <p>Description</p>
    <input type="text" name="description"/>

    <button type="submit">Save</button>
</form>
</body>
</html>
