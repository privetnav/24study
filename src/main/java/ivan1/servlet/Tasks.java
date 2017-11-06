package ivan1.servlet;

import ivan1.db.dao.TaskDAO;
import ivan1.entities.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Tasks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("header.jsp?title=Разбор темы").include(req, resp);

        if(req.getSession() != null && req.getSession().getAttribute("isAuth").equals(true)) {
            if(null != req.getParameter("id")) {
                int id = Integer.parseInt(req.getParameter("id"));
                try {
                    ivan1.entities.Tasks taskList = TaskDAO.getAll(id);
                    resp.getWriter().println("<h1 class=\"title\"></h1>");
                    if (taskList.size() > 0) {
                        resp.getWriter().println("<ul class=\"listLesson\">");
                        for (Task task : taskList.getTasks()) {
                            resp.getWriter().println("<li><h2>" + task.getTaskName() + "</h2><div class=\"courseDesc\">" + task.getTaskInfo() + "</div></li>");
                        }
                        resp.getWriter().println("</ul>");
                    }
                    else {
                        resp.getWriter().println("<p>Список тем пуст.</p>");
                    }

                } catch (TaskDAO.TaskDAOException e) {
                    e.printStackTrace();
                }
            }
            else {
                resp.getWriter().println("Лекция не найдена");
            }
        }
        else {
            resp.getWriter().println("Доступ закрыт.");
        }

        req.getRequestDispatcher("footer.jsp").include(req, resp);
    }
}
