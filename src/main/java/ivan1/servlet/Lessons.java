package ivan1.servlet;

import ivan1.db.dao.LessonDAO;
import ivan1.entities.Lesson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Lessons extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("header.jsp?title=Список тем").include(req, resp);

        if(req.getSession() != null && req.getSession().getAttribute("isAuth").equals(true)) {
            if(null != req.getParameter("id")) {
                int id = Integer.parseInt(req.getParameter("id"));
                //resp.getWriter().println(id);
                try {
                    ivan1.entities.Lessons lessonList = LessonDAO.getAll(id);
                    resp.getWriter().println("<h1 class=\"title\">Список тем</h1>");
                    if (lessonList.size() > 0) {
                        resp.getWriter().println("<ul class=\"listLesson\">");
                        for (Lesson lesson : lessonList.getLessons()) {
                            resp.getWriter().println("<li><a href=\"/tasks?id=" + lesson.getId() + "\">" + lesson.getLessonName() + "</a><div class=\"courseDesc\">" + lesson.getLessonDescription() + "</div></li>");
                        }
                        resp.getWriter().println("</ul>");
                    }
                    else {
                        resp.getWriter().println("<p>Список курсов пуст.</p>");
                    }

                } catch (LessonDAO.LessonDAOException e) {
                    e.printStackTrace();
                }
            }
            else {
                resp.getWriter().println("Курс не найден");
            }
        }
        else {
            resp.getWriter().println("Доступ закрыт.");
        }
        req.getRequestDispatcher("footer.jsp").include(req, resp);
    }
}
