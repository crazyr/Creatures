<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<html>
<head>
    <title><fmt:message key="title.admin_create_creature"/></title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../parts/header.jsp"%>
<div align="left">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_ADMIN_MAIN_PAGE_COMMAND"/>
        <input type="submit" value="<fmt:message key="button.main_page"/>" class="nice-button"/>
    </form>
</div>

<div align="center">
    <form action="/creatures" method="post">
        <input type="hidden" name="commandType" value="CREATE_CREATURE_COMMAND"/>
        <jsp:include page="../parts/enter_creature_data_part.jsp"/>
        <input type="submit" value="<fmt:message key="button.create"/>" class="nice-button"/>
    </form>
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>
</fmt:bundle>