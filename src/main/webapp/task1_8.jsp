<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.03.2021
  Time: 6:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>task1_8</title>
</head>
<body>
<hr/>
<form method="post" action="" >
    <label>
        <input type="text" name="text1" value="${param.button1 != null ? requestScope.text1 : "the richest user"}" readonly/>
    </label>
    <button name="button1">get</button>
<br/>
    <label>
        <input type="text" name="text2" value="${param.button2 != null ? requestScope.text2 : "accounts sum"}" readonly/>
    </label>
    <button name="button2">get</button>
</form>
<hr/>
</body>
</html>
