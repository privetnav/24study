package ivan1.servlet;

import ivan1.services.RegistrationService;
import ivan1.services.RegistrationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {
    private static RegistrationService rg = new RegistrationServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Как сделать escape
        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String patronymic = req.getParameter("patronymic");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String city = req.getParameter("city");
        String passwordTwo = req.getParameter("passwordTwo");

        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("header.jsp?title=Список курсов").include(req, resp);

        if(rg.newRegistration(login, password, name, family, patronymic, city) != 0) {
            resp.getWriter().println("Регистрация прошла успешно");
        }
        else {
            resp.getWriter().println("При ошибке произошла ошибка");
        }

        req.getRequestDispatcher("footer.jsp").include(req, resp);
    }
}
