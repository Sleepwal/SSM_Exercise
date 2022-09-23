<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showDownFiles</title>
</head>
<body>
    <table>
        <tr>
            <td>被下载的文件名</td>
        </tr>

        <%-- 遍历model中的files --%>
        <c:forEach items="${files}" var="filename">
            <tr>
                <td><a href="${pageContext.request.contextPath}/down?filename=${filename}">${filename}</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
