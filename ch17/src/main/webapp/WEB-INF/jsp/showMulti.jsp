<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showMulti</title>
</head>
<body>

    <table>
        <tr>
            <td>详情</td>
            <td>文件名</td>
        </tr>

        <%-- 同时取两个数据的元素 --%>
        <c:forEach items="${multiFileDomain.description}" var="description" varStatus="loop">
            <tr>
                <td>${description}</td>
                <td>${multiFileDomain.myfile[loop.count-1].originalFilename}</td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
