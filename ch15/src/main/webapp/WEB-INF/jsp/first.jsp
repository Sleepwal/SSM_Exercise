<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>first</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/i18NTest?locale=zh_CN">
        <spring:message code="language.cn"/>
    </a> --

    <a href="${pageContext.request.contextPath}/i18NTest?locale=en_US">
        <spring:message code="language.en"/>
    </a> --
    <br><br>

    <spring:message code="first"/><br><br>
    <a href="${pageContext.request.contextPath}/my/second">
        <spring:message code="second"/>
    </a>

</body>
</html>
