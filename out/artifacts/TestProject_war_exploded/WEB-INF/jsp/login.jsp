<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/19
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>


<form action="login" method="post">
    用户名:<input type="text" name="userName"/><br/>
    密码:<input type="password" name="passWord"/>

    <input type="submit" value="登录"/>
    <a href="register"></a>
</form>
</body>
</html>
