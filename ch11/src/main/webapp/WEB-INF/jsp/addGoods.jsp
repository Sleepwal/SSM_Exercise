<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addGoods</title>
</head>
<body>
<h1 align="center">内置类型转换器</h1>
<form action="${pageContext.request.contextPath}/addGoods" method="post" name="loginForm" align="center">
    <table bgcolor="#8fbc8f" align="center">
        <tr>
            <td>商品名称:</td>
            <td>
                <input class="testSize" type="text" name="goodsname"/>
            </td>
        </tr>

        <tr>
            <td>商品价格:</td>
            <td>
                <input class="textSize" type="text" name="goodsprice"/>
            </td>
        </tr>

        <tr>
            <td>商品数量:</td>
            <td>
                <input class="textSize" type="text" name="goodnumber"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>

<h1 align="center">自定义类型转换器</h1>
<form action="${pageContext.request.contextPath}/my/converter" method="post" align="center">
    <table bgcolor="#8fbc8f" align="center">
        <thead>请输入商品信息(apple,10.58,200)</thead>
        <tr>
            <td>商品信息:</td>
            <td>
                <input class="testSize" type="text" name="goods"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>

<h1 align="center">自定义格式转换器</h1>
<form action="${pageContext.request.contextPath}/my/formatter" method="post" align="center">
    <table bgcolor="#8fbc8f" align="center">
        <tr>
            <td>商品名称:</td>
            <td>
                <input class="testSize" type="text" name="goodsname"/>
            </td>
        </tr>

        <tr>
            <td>商品价格:</td>
            <td>
                <input class="textSize" type="text" name="goodsprice"/>
            </td>
        </tr>

        <tr>
            <td>商品数量:</td>
            <td>
                <input class="textSize" type="text" name="goodsnumber"/>
            </td>
        </tr>

        <tr>
            <td>商品日期:</td>
            <td>
                <input class="textSize" type="text" name="goodsdate"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
