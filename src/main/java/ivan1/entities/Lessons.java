package ivan1.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "lessons")
public class Lessons {
    private List<Lesson> lessons;
    public Lessons() {
        lessons = new ArrayList<>();
    }

    @XmlElement(name="lesson")
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
    public List<Lesson> getLessons() {
        return lessons;
    }
    public void addLesson(Lesson temp) {
        lessons.add(temp);
    }
    public int size() {
        return lessons.size();
    }
}
