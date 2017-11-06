<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
  <title>Summator</title>
</head>
<body>
  <form:form action="/appendSumm" method="post">
    <form:input path="value" size="20"></form:input>
    <input type="submit" value="Submit"/>
  </form:form>
</body>
</html>
