<% request.setCharacterEncoding("utf-8"); %>
<%@ page pageEncoding="UTF-8"%>

  <h1 class="title">Вход на сайт</h1>
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
        <td><input type="submit" value="Войти"/></td>
        <td><a href="/registration.jsp" class="regBut">Регистрация</a></td>
      </tr>
    </table>
  </form>
