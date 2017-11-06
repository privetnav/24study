<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>${sum}</h1>
<form action="/append" method="post">
  <input type="text" name="sum" size="15"/>
  <button type="submit">Submit</button>
</form>

<form action="/move" method="post">
  <button type="submit">Move</button>
</form>
</body>
</html>
