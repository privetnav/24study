package ivan1.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "tasks")
public class Tasks {
    private List<Task> tasks;
    public Tasks() {
        tasks = new ArrayList<>();
    }

    @XmlElement(name="task")
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public void addLesson(Task temp) {
        tasks.add(temp);
    }
    public int size() {
        return tasks.size();
    }
}
