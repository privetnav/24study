package ivan1.servlet;

import ivan1.services.AuthorizationService;
import ivan1.services.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Autentication extends HttpServlet {
    private static AuthorizationService as = new AuthorizationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("header.jsp?title=Список курсов").include(req, resp);

        resp.getWriter().println("Доступ закрыт");

        req.getRequestDispatcher("footer.jsp").include(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        //req.getRequestDispatcher("courses").forward(req, resp);

        if (as.auth(login, password)) {
            //resp.getWriter().println(login + " " + password);
            req.getSession().setAttribute("isAuth", true);
            resp.sendRedirect("courses");



            //            req.getRequestDispatcher("/hello").forward(req, resp);
           //req.getRequestDispatcher("Courses").forward(req, resp);
        } else {
            resp.setCharacterEncoding("utf-8");
            req.getRequestDispatcher("header.jsp?title=Ошибка входа").include(req, resp);

            resp.getWriter().println("<p>Доступ закрыт, авторизуйтесь или зарегистрируйтесь.</p>");


            req.getRequestDispatcher("loginForm.jsp").include(req, resp);

            req.getRequestDispatcher("footer.jsp").include(req, resp);
            //getServletContext().getRequestDispatcher("/").forward(req, resp);
        }


    }
}
