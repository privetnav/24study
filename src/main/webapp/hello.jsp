<%--
  Created by IntelliJ IDEA.
  User: vidok
  Date: 24.10.17
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>${summa}</h1>
<form action="/mvc-sample/append" method="post">
    <input type="text" name="input">
    <input type="submit" value="Submit">
</form>
<form action="/mvc-sample/move" method="get">
    <button type="submit">Submit</button>
</form>
</body>
</html>
