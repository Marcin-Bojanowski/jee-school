<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-16
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page  contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add group</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h1>Add group</h1>
Group name
<form action="/addGroup" method="post">
    <input type="text" name="name"/>
    <button type="submit">Save</button>
</form>
</body>
</html>
