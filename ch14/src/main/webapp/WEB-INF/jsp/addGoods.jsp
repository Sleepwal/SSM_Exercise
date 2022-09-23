<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addGoods</title>
</head>
<body>
<form:form modelAttribute="goods" method="post" action="${pageContext.request.contextPath}/goods/save">
    <fieldset>
        <legend>添加一件商品</legend>
        <p>
            <label>商品名: </label>
            <form:input path="gname"/>
        </p>
        <p>
            <label>商品详情: </label>
            <form:input path="gdescription"/>
        </p>
        <p>
            <label>商品价格: </label>
            <form:input path="gprice"/>
        </p>
        <p>
            <label>创建日期: </label>
            <form:input path="gdate"/>(yyyy-MM-dd)
        </p>

        <p id="buttons">
            <input id="reset" type="reset"/>
            <input id="submit" type="submit" value="添加"/>
        </p>
    </fieldset>

    <%-- 取出所有验证错误 --%>
    <form:errors path="*"/>
</form:form>

</body>
</html>
