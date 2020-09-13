<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-24
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User panel</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h1>Finished exercises</h1>
<a href="logout">Logout</a>
<table border="1" cellpadding="2" cellspacing="2">
    <tr>
        <td>
            Exercise name
        </td>
        <td>
            Created
        </td>
        <td>
            Updated
        </td>
        <td>
            Exercise description
        </td>
        <td>
            Solution
        </td>

    </tr>
    <c:forEach varStatus="loop" items="${doneSolutions}">
        <tr>
            <td>
                <c:out value="${doneExercises[loop.index].title}"></c:out>
            </td>
            <td>
            <c:out value="${doneSolutions[loop.index].created}"></c:out>
            </td>
            <td>
                <c:out value="${doneSolutions[loop.index].updated}"></c:out>
            </td>
            <td>
                <c:out value="${doneExercises[loop.index].description}"></c:out>
            </td>
            <td>
                <c:out value="${doneSolutions[loop.index].description}"></c:out>
            </td>

        </tr>
    </c:forEach></p>
</table>
    <h1>Not finished exercises</h1>

    <table border="1" cellpadding="2" cellspacing="2">
        <tr>
            <td>
                Exercise name
            </td>
            <td>
                Created
            </td>
            <td>
                Exercise description
            </td>

            <td>
               Action
            </td>
        </tr>
        <c:forEach varStatus="loop" items="${notDoneSolutions}">
            <tr>
                <td>
                    <c:out value="${notDoneExercises[loop.index].title}"></c:out>
                </td>
                <td>
                    <c:out value="${notDoneSolutions[loop.index].created}"></c:out>
                </td>
                <td>
                    <c:out value="${notDoneExercises[loop.index].description}"></c:out>
                </td>

                <td>
                    <a href="addSolution?id=${notDoneSolutions[loop.index].id}">Add solution</a>
                </td>
            </tr>
        </c:forEach>

</table>

</body>
</html>
