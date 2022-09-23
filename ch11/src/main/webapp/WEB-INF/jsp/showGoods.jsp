<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showGoods</title>
</head>
<body>
    <h1>自定义类型转换器</h1>
    您添加的商品如下: <br/>
    <ul>
        <li>商品名称: ${goods.goodsname}</li>
        <li>商品价格: ${goods.goodsprice}</li>
        <li>商品数量: ${goods.goodsnumber}</li>
    </ul>

    <h1>自定义格式转换器</h1>
    您添加的商品如下: <br/>
    <ul>
        <li>商品名称: ${goods2.goodsname}</li>
        <li>商品价格: ${goods2.goodsprice}</li>
        <li>商品数量: ${goods2.goodsnumber}</li>
        <li>商品日期: ${goods2.goodsdate}</li>
    </ul>
</body>
</html>
