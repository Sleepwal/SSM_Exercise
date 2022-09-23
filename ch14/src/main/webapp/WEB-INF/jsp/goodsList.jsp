<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GoodsList</title>
</head>
<body>
    <table>
        <tr>
            <th>商品名</th>
            <th>商品详情</th>
            <th>商品价格</th>
            <th>创建日期</th>
        </tr>

        <c:forEach items="${goodsList}" var="goods">
            <tr>
                <td>${goods.gname}</td>
                <td>${goods.gdescription}</td>
                <td>${goods.gprice}</td>
                <td>${goods.gdate}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
