
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post" name="loginForm">
    <table bgcolor="#8fbc8f" align="center">
        <tr>
            <td>姓名:</td>
            <td>
                <input class="testSize" type="text" name="uname" value="${uname}"/>
            </td>
        </tr>

        <tr>
            <td>密码:</td>
            <td>
                <input class="textSize" type="password" name="upass"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
