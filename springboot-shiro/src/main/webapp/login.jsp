<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
</head>
<body>
    <h1>登录页面</h1>

    <form action="${pageContext.request.contextPath}/user/login", method="post">
        用户名：<input type="text" name="username"> <br/>
        密码  ：<input type="text" name="password"> <br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>