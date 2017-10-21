package ivan1.entities;

import javax.xml.bind.annotation.*;

@XmlRootElement
//@XmlType(propOrder = {"firstName", "family", "patronymic", "city"})
public class User {
    private int id;
    private String firstName;
    private String family;
    private String patronymic;
    private String city;

    public User(int id, String firstName, String family, String patronymic, String city) {
        this.id =id;
        this.firstName = firstName;
        this.family = family;
        this.patronymic = patronymic;
        this.city = city;
    }
    public User() {

    }
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public void setFamily(String family) {
        this.family = family;
    }

    @XmlElement
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamily() {
        return family;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getCity() {
        return city;
    }

    public void printUser() {
        System.out.println(id + " " + firstName + " " + family + " " + patronymic + " " + city);
    }


}
