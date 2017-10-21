package ivan1.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "courses")
public class Courses {
    private List<Course> courses;
    public Courses() {
        courses = new ArrayList<>();
    }

    @XmlElement(name="course")
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course temp) {
        courses.add(temp);
    }
}
