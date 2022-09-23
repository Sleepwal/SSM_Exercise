<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>third</title>
</head>
<body>

    <spring:message code="third" arguments="555, 666"/><br><br>
    <a href="${pageContext.request.contextPath}/my/first">
        <spring:message code="first"/>
    </a>

</body>
</html>
