<% request.setCharacterEncoding("utf-8"); %>
<%@ page pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp" >
    <jsp:param name="title" value="Регистрация" />
</jsp:include>
    <h1>Регистрация пользователя</h1>
    <form id="myForm" method="post" action="/reg">
        <table cellpadding="10">
            <tr>
                <td>Имя: <span class="red">*</span></td>
                <td>
                    <input type="text" name="name" required>
                </td>
            </tr>
            <tr>
                <td>Фамилия: <span class="red">*</span></td>
                <td>
                    <input type="text" name="family" required>
                </td>
            </tr>
            <tr>
                <td>Отчество:</td>
                <td>
                    <input type="text" name="patronymic" required>
                </td>
            </tr>
            <tr>
                <td>Город:</td>
                <td>
                    <input type="text" name="city" required>
                </td>
            </tr>
            <tr>
                <td>Почта: <span class="red">*</span></td>
                <td>
                    <input type="email" name="login" required>
                </td>
            </tr>
            <tr>
                <td>Пароль: <span class="red">*</span></td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>Подтверждение пароля: <span class="red">*</span></td>
                <td><input type="password" name="passwordTwo" required></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="Зарегистрироваться"/></td>
            </tr>
        </table>

        <div class="star"><span class="red">*</span> поля обязательные для заполнения</div>
    </form>
<jsp:include page="/footer.jsp" />


