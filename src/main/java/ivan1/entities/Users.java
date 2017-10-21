package ivan1.entities;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
public class Users {
    private List<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    @XmlElement(name="user")
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<User> getUsers() {
        return users;
    }
    public void addUser(User temp) {
        users.add(temp);
    }


}
