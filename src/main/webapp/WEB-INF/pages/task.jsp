<% request.setCharacterEncoding("utf-8"); %>
<%@ page pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp" >
    <jsp:param name="title" value="Вход на сайт" />
</jsp:include>

Текст
<h1>${task}</h1>

<jsp:include page="/footer.jsp" />