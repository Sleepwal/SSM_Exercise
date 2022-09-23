<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" %>
<html>
<head>
    <title>my-error</title>
</head>
<body>
    <h1>自定义异常错误: </h1> <%=exception%>
    <h2>错误内容: </h2>
    <div>
        <%
            exception.printStackTrace(response.getWriter());
        %>
    </div>

</body>
</html>
