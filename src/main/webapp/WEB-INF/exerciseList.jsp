<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-18
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Exercise list</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h1>Exercise list</h1>
<a href="addExercise">Add new</a>
<table border="1" cellpadding="2" cellspacing="2">
    <tr>
        <td>
            Exercise title
        </td>
        <td>
            Exercise description
        </td>

        <td>
            Actions
        </td>
    </tr>
    <c:forEach varStatus="loop" items="${exerciseList}">
        <tr>
            <td>
                <c:out value="${exerciseList[loop.index].title}"></c:out>
            </td>
            <td>
                <c:out value="${exerciseList[loop.index].description}"></c:out>
            </td>
            <td>
                <a href="editExercise?id=${exerciseList[loop.index].id}">Edit</a>
                <a href="deleteExercise?id=${exerciseList[loop.index].id}">Delete</a>
                <a href="solutionToUser?id=${exerciseList[loop.index].id}">Add to user</a>
                <a href="solutionToGroup?id=${exerciseList[loop.index].id}">Add to group</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
