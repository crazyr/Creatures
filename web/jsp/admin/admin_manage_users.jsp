<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 01.07.2018
  Time: 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<html>
<head>
    <title><fmt:message key="title.admin_manage_users"/></title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../parts/header.jsp"%>
<br/>
<div align="left">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_ADMIN_MAIN_PAGE_COMMAND"/>

        <input type="submit" value="<fmt:message key="button.main_page"/>" class="nice-button"/>
    </form>
</div>
<br/>
<div align="left">
    <form id="sortForm" action="/creatures" method="get">
        <input type="hidden" name="commandType" value="CHANGE_USER_SORT_TYPE_COMMAND"/>
        <select class="custom-select" name="sortUser" oninput="document.getElementById('sortForm').submit()">
            <option hidden><fmt:message key="label.sort"/></option>
            <option value="BY_LOGIN"><fmt:message key="label.sort.user.by_login"/></option>
            <option value="BY_STATUS"><fmt:message key="label.sort.user.by_status"/></option>
        </select>
    </form>
</div>
<br/>
<div>
<c:import url="/creatures?commandType=SHOW_USERS_COMMAND"/>
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>
</fmt:bundle>