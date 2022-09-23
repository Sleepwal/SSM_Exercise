<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/register" method="post" name="registForm">
        <table border="1" bgcolor="#20b2aa" align="center">
            <tr>
                <td>姓名:</td>
                <td>
                    <input class="testSize" type="text" name="uname" value="${uname}"/>
                </td>
            </tr>

            <tr>
                <td>密码:</td>
                <td>
                    <input class="textSize" type="password" maxlength="20" name="upass"/>
                </td>
            </tr>

            <tr>
                <td>确认密码:</td>
                <td>
                    <input class="textSize" type="password" maxlength="20" name="reupass"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
