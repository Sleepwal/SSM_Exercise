<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.js"></script>
    <script type="text/javascript">
        function testJson() {
            const pname = $("#pname").val();
            const password = $("#password").val();
            const page = $("#page").val();

            $.ajax({
                url: "${pageContext.request.contextPath}/testJson",
                type: "post",
                data: JSON.stringify({
                    pname: pname,
                    password: password,
                    page: page
                }),
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                success: function (data) {
                    if(data != null){
                        alert("用户名: " + data.pname + ", password: " + data.password +
                        ", age: " + data.page);
                    }
                }
            });
        }
    </script>
</head>
<body>
    <form action="">
        用户名: <input type="text" name="pname" id="pname"/><br/>
        密码: <input type="password" name="password" id="password"/><br/>
        年龄: <input type="text" name="page" id="page"/><br/>
        <input type="button" value="test" onclick="testJson()"/>
    </form>
</body>
</html>
