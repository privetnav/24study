package ivan1.servlet;

import ivan1.db.dao.CourseDAO;
import ivan1.entities.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Courses extends HttpServlet {
    //private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Courses.class);
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("header.jsp?title=Список курсов").include(req, resp);

        if(req.getSession() != null && req.getSession().getAttribute("isAuth").equals(true)) {
            try {
                //log.debug("Курсы были выведены");
                ivan1.entities.Courses courseList = CourseDAO.getAll();
                resp.getWriter().println("<h1 class=\"title\">Список курсов</h1>");
                resp.getWriter().println("<ul class=\"listLesson\">");
                for(Course course : courseList.getCourses()) {
                    resp.getWriter().println("<li><a href=\"/lessons?id=" + course.getId() + "\">"+ course.getCourseName() + "</a><div class=\"courseDesc\">" + course.getCourseDescription() +  "</div></li>");
                }
                resp.getWriter().println("</ul>");
            } catch (CourseDAO.CourseDAOException e) {
                e.printStackTrace();
            }
        }
        else {
            resp.getWriter().println("Доступ закрыт.");
        }
        req.getRequestDispatcher("footer.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Доступ закрыт.");
    }
}
