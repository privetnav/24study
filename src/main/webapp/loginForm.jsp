<% request.setCharacterEncoding("utf-8"); %>
<%@ page pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp" >
  <jsp:param name="title" value="Вход на сайт" />
</jsp:include>

  <form id="myForm" method="post" action="/auth">
    <table cellpadding="10">
      <tr>
        <td>Логин:</td>
        <td>
          <input type="text" name="login" required>
        </td>
      </tr>
      <tr>
        <td>Пароль:</td>
        <td><input type="password" name="password" required></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="Войти"/></td>
      </tr>
    </table>
  </form>
<jsp:include page="/footer.jsp" />