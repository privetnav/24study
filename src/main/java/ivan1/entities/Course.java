package ivan1.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {
    private int id;
    private String courseName;
    private String courseDescription;

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    @XmlElement
    public String getCourseDescription() {

        return courseDescription;
    }

    public Course(int id, String courseName, String courseDescription) {
        this.id = id;
        this.courseName = courseName;
        this.courseDescription = courseDescription;

    }
    public Course() {

    }
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void printCourse() {
        System.out.println(id + " " + courseName);
    }
}
