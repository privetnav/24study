package ivan1.db.dao;

import ivan1.db.ConnectionManagerMySQL;
import ivan1.db.IConnectionManager;
import ivan1.entities.Lesson;
import ivan1.entities.Lessons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LessonDAO {
    private static IConnectionManager manager;
    static {
        manager = ConnectionManagerMySQL.getInstance();
    }
    public static class LessonDAOException extends Exception {

    }

    public static Lessons getAll() throws LessonDAO.LessonDAOException {
        Lessons lessonList = new Lessons();
        try {
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM lesson");

            while (resultSet.next()) {
                Lesson tempLesson;
                tempLesson = new Lesson(
                        resultSet.getInt("les_id"),
                        resultSet.getString("lesson_name"),
                        resultSet.getString("lesson_description")
                );
                lessonList.addLesson(tempLesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LessonDAO.LessonDAOException();
        }
        return lessonList;
    }

    public static Lessons getAll(int id) throws LessonDAO.LessonDAOException {
        Lessons lessonList = new Lessons();
        try {
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM lesson WHERE course_id = " + id);

            while (resultSet.next()) {
                Lesson tempLesson;
                tempLesson = new Lesson(
                        resultSet.getInt("les_id"),
                        resultSet.getString("lesson_name"),
                        resultSet.getString("lesson_description")
                );
                lessonList.addLesson(tempLesson);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LessonDAO.LessonDAOException();
        }
        return lessonList;
    }
}
