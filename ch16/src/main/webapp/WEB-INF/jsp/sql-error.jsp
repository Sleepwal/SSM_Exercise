<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" %>
<html>
<head>
    <title>sql-error</title>
</head>
<body>
    <h1>数据库异常错误: </h1> <%=exception%>
    <h2>错误内容: </h2>
    <%
        exception.printStackTrace(response.getWriter());
    %>
</body>
</html>
