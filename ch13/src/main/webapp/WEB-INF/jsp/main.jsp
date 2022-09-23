<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    当前用户: ${user.username}<br/>
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>
