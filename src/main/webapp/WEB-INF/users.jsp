<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-16
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<table border="1" cellpadding="2" cellspacing="2">
    <tr>
        <td>
            Name
        </td>
        <td>
            Actions
        </td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <c:out value="${user.name}"></c:out>
            </td>
            <td>
                <a href="userDetails?id=${user.id}">Details</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
