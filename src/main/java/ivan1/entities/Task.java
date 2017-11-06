package ivan1.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task {
    private int id;
    private String taskName;
    private String taskInfo;
    private String taskVideo;

    public Task(int id, String taskName, String taskInfo, String taskVideo) {
        this.id = id;
        this.taskName = taskName;
        this.taskInfo = taskInfo;
        this.taskVideo = taskVideo;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @XmlElement
    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    @XmlElement
    public String getTaskVideo() {
        return taskVideo;
    }

    public void setTaskVideo(String taskVideo) {
        this.taskVideo = taskVideo;
    }
}
