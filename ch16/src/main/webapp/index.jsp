<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h1>演示例子</h1>
    <h3><a href="${pageContext.request.contextPath}/daodb">处理dao中数据库异常</a> </h3>
    <h3><a href="${pageContext.request.contextPath}/daomy">处理dao中自定义异常</a> </h3>
    <h3><a href="${pageContext.request.contextPath}/daono">处理dao中未知异常</a> </h3>

    <h3><a href="${pageContext.request.contextPath}/servicedb">处理service中数据库异常</a> </h3>
    <h3><a href="${pageContext.request.contextPath}/servicemy">处理service中自定义异常</a> </h3>
    <h3><a href="${pageContext.request.contextPath}/serviceno">处理service中未知异常</a> </h3>

    <h3><a href="${pageContext.request.contextPath}/db">处理controller中数据库异常</a> </h3>
    <h3><a href="${pageContext.request.contextPath}/my">处理controller中自定义异常</a> </h3>
    <h3><a href="${pageContext.request.contextPath}/no">处理controller中未知异常</a> </h3>
    <hr/>
    <%-- 在web.xml中配置404 --%>
    <h3><a href="${pageContext.request.contextPath}/404">404错误</a> </h3>


</body>
</html>
