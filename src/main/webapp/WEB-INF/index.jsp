<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-15
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<table border="1" cellpadding="2" cellspacing="2">
    <tr>
        <td>
            Exercise name
        </td>
        <td>
            Solution author
        </td>
        <td>
            Date
        </td>
        <td>
            Actions
        </td>
    </tr>
    <c:forEach varStatus="loop" items="${recentSolutions}">
        <tr>
            <td>
                <c:out value="${exercise[loop.index].title}"></c:out>
            </td>
            <td>
                <c:out value="${users[loop.index].name}"></c:out>
            </td>
            <td>
                <c:out value="${recentSolutions[loop.index].updated}"></c:out>
            </td>
            <td>
                <a href="details?id=${recentSolutions[loop.index].id}">Details</a>
            </td>
                <%--        <form method="get">--%>
                <%--            <td>--%>
                <%--                <input type="number" name="quantity"/>--%>
                <%--            </td>--%>
                <%--            <td>--%>
                <%--                <button type="submit" value="${product.id}" name="id">Dodaj</button>--%>
                <%--            </td>--%>

                <%--        </form>--%>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
