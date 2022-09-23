<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    ${msg}<br/>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名: <input type="text" name="username"><br/>
        密码: <input type="password" name="password"><br/>
        <input type="submit" value="login">
    </form>
</body>
</html>
