package ivan1.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lesson {
    private int id;
    private String lessonName;
    private String lessonDescription;

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @XmlElement
    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public Lesson(int id, String lessonName, String lessonDescription) {

        this.id = id;
        this.lessonName = lessonName;
        this.lessonDescription = lessonDescription;
    }
}
