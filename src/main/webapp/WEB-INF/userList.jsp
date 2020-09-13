<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-17
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h1>Users</h1>
<a href="addUser">Add new</a>
<table border="1" cellpadding="2" cellspacing="2">
    <tr>
        <td>
            User name
        </td>
        <td>
            User email
        </td>
        <td>
            Group
        </td>
        <td>
            Actions
        </td>
    </tr>
    <c:forEach varStatus="loop" items="${userList}">
        <tr>
            <td>
                <c:out value="${userList[loop.index].name}"></c:out>
            </td>
            <td>
                <c:out value="${userList[loop.index].email}"></c:out>
            </td>
            <td>
                <c:out value="${group[loop.index].name}"></c:out>
            </td>
            <td>
                <a href="editUser?id=${userList[loop.index].id}">Edit</a>
                <a href="deleteUser?id=${userList[loop.index].id}">Delete</a>
                <a href="userDetails?id=${userList[loop.index].id}">Details</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
