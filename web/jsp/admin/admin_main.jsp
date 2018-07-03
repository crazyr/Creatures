<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 01.07.2018
  Time: 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../header.jsp"/>

<div align="right">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_CREATE_CREATURE_PAGE_COMMAND"/>

        <input type="submit" value="Create new creature" class="nice-button"/>
    </form>
</div>

<c:import url="/creatures?commandType=SHOW_CREATURES_COMMAND"/>
</body>
</html>
