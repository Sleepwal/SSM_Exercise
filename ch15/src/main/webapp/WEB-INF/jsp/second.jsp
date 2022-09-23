<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>second</title>
</head>
<body>
    <spring:message code="second"/><br><br>
    <a href="${pageContext.request.contextPath}/my/third">
        <spring:message code="third" arguments="555, 666"/>
    </a>
</body>
</html>
