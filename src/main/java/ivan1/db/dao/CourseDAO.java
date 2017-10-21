package ivan1.db.dao;


import ivan1.db.ConnectionManagerMySQL;
import ivan1.db.IConnectionManager;
import ivan1.entities.Course;
import ivan1.entities.Courses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseDAO {
    private static IConnectionManager manager;
    static {
        manager = ConnectionManagerMySQL.getInstance();
    }
    public static class CourseDAOException extends Exception {

    }

    public static Courses getAll() throws CourseDAO.CourseDAOException {
        Courses courseList = new Courses();
        try {
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM course");

            while (resultSet.next()) {
                Course tempCourse;
                tempCourse = new Course(
                        resultSet.getInt("cour_id"),
                        resultSet.getString("course_name"),
                        resultSet.getString("course_description")
                );
                courseList.addCourse(tempCourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CourseDAO.CourseDAOException();
        }
        return courseList;
    }
}
