package ivan1.servlet;

import ivan1.db.dao.CourseDAO;
import ivan1.entities.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Courses extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("header.jsp?title=Список курсов").include(req, resp);
        /*
        resp.getWriter().println("<!DOCTYPE html>");
        resp.getWriter().println("<html>");
        resp.getWriter().println("\t<head>");
        resp.getWriter().println("<meta charset=\"utf-8\">");
        resp.getWriter().println("\t<title>Список курсов</title>");
        resp.getWriter().println("\t</head>");
        resp.getWriter().println("\t<body>");
        resp.getWriter().println("Список курсов.");
*/
        if(req.getSession() != null && req.getSession().getAttribute("isAuth").equals(true)) {
            try {
                ivan1.entities.Courses courseList = CourseDAO.getAll();
                resp.getWriter().println("<h1 class=\"title\">Список курсов</h1>");
                resp.getWriter().println("<ul class=\"listLesson\">");
                for(Course course : courseList.getCourses()) {
                    resp.getWriter().println("<li><a href=\"/lesson\">"+ course.getCourseName() + "</a><div class=\"courseDesc\">" + course.getCourseDescription() +  "</div></li>");
                }
                resp.getWriter().println("</ul>");
            } catch (CourseDAO.CourseDAOException e) {
                e.printStackTrace();
            }
        }
        else {
            resp.getWriter().println("Доступ закрыт.");
        }
            /*
           //Users userList = UserDAO.getAll();
            /*
            for(User user : userList.getUsers()){
                user.printUser();
            }
        }
        else {
            resp.getWriter().println("Доступ закрыт");
        }

/*
        resp.getWriter().println("Hello! Привет!");
        resp.getWriter().println("<img src=\"images/dog.jpeg\">");
        resp.getWriter().println("Die world!");
*/
        req.getRequestDispatcher("footer.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
