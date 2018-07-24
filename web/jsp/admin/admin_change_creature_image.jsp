<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13.07.2018
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<html>
<head>
    <title><fmt:message key="title.admin_change_creature_image"/></title>
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
<br/>
<div align="center">
    <form action="/upload" enctype = "multipart/form-data" method="post">
        <input type="hidden" name="pictureType" value="CREATURE_IMAGE"/>
        <input type="hidden" name="creatureId" value="${creatureId}"/>
        <input type="file" name="picture" accept="image/x-png, image/gif, image/jpeg" formenctype="multipart/form-data" maxlength="3072" required class="nice-button"/>
        <br/><br/>
        <input type="submit" value="<fmt:message key="button.update_image"/>" class="nice-button"/>
    </form>
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>
</fmt:bundle>