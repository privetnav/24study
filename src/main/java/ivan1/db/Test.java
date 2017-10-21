package ivan1.db;

import ivan1.entities.User;
import ivan1.db.dao.UserDAO;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            List<User> userList = (List<User>) UserDAO.getAll();
            for(User user : userList){
                user.printUser();
            }
        } catch (UserDAO.UserDAOException e) {
            e.printStackTrace();
        }

    }
}
