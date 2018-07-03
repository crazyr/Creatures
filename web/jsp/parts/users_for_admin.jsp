<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align="center">
    <table width="80%">
        <caption align="center" class="nice-text">
            Users
        </caption>
        <thead>
        <tr>
            <th>Login</th>
            <th>Status</th>
            <th>Banned</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.getLogin()}"/></td>
                <td><c:out value="${user.getStatus()}"/></td>
                <td><c:out value="${user.getBanned()}"/></td>
                <td>
                    <form action="/creatures" method="get">
                        <input type="hidden" name="commandType" value="CHANGE_USER_BANNED_COMMAND"/>
                        <input type="hidden" name="userId" value="${user.getId()}"/>

                        <input type="submit" value="Ban\Unban" class="nice-table-button"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
</div>
</body>
</html>