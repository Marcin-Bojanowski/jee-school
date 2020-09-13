<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-16
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User details</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<p>User name: <c:out value="${userDetails.name}"></c:out></p>
<p>User email: <c:out value="${userDetails.email}"></c:out></p>
<table border="1" cellpadding="2" cellspacing="2">
    <tr>
        <td>
            Exercise name
        </td>
        <td>
            Date
        </td>
        <td>
            Actions
        </td>
    </tr>
    <c:forEach varStatus="loop" items="${userSolutions}">
        <tr>
            <td>
                <c:out value="${userExercises[loop.index].title}"></c:out>
            </td>
            <td>
                <c:out value="${userSolutions[loop.index].updated}"></c:out>
            </td>
            <td>
                <a href="details?id=${userSolutions[loop.index].id}">Details</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
