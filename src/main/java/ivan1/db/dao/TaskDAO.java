package ivan1.db.dao;

import ivan1.db.ConnectionManagerMySQL;
import ivan1.db.IConnectionManager;
import ivan1.entities.Task;
import ivan1.entities.Tasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskDAO {
    private static IConnectionManager manager;
    static {
        manager = ConnectionManagerMySQL.getInstance();
    }
    public static class TaskDAOException extends Exception {

    }

    public static Tasks getAll(int id) throws TaskDAO.TaskDAOException {
        Tasks taskList = new Tasks();
        try {
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM task JOIN  lesson_relations_task ON task.task_id = lesson_relations_task.task_id  WHERE lesson_num = " + id);

            while (resultSet.next()) {
                Task tempTask;
                tempTask = new Task(
                        resultSet.getInt("task_id"),
                        resultSet.getString("task_name"),
                        resultSet.getString("task_info"),
                        resultSet.getString("task_video")
                );
                taskList.addLesson(tempTask);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new TaskDAO.TaskDAOException();
        }
        return taskList;
    }
}
