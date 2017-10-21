package ivan1.db.dao;

import ivan1.entities.User;
import ivan1.entities.Users;
import ivan1.db.ConnectionManagerMySQL;
import ivan1.db.IConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAO {
    private static IConnectionManager manager;
    static {
        manager = ConnectionManagerMySQL.getInstance();
    }
    public static class UserDAOException extends Exception {

    }

    public static void saveAll(Users users) throws SQLException {
        Statement statement = manager.getConnection().createStatement();//use prepared statement
        //PreparedStatement statement = manager.getConnection().prepareStatement("INSERT INTO user (us_id, first_name, family, patronymic, city) VALUES (NULL, '?', '?', '?', '?')");
//parser.saveObject(file, userList);
        List<User> temp= users.getUsers();

        for (int i=0; i< temp.size(); i++) {


            statement.executeUpdate("INSERT INTO user (us_id, first_name, family, patronymic, city) VALUES (NULL, '" + temp.get(i).getFirstName() + "', '" + temp.get(i).getFamily() + "', '" + temp.get(i).getPatronymic() + "', '" + temp.get(i).getCity() + "')");
        }
    }


    public static Users getAll() throws UserDAOException {
        //List<User> userList = new ArrayList<>();
        Users userList = new Users();
        try {
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
               // System.out.println(resultSet.getInt("us_id"));
               // System.out.println(resultSet.getInt("firstName"));

                User tempUser;
                tempUser = new User(
                        resultSet.getInt("us_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("city")
                        );

                userList.addUser(tempUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserDAOException();
        }
        return userList;
    }

    public static int getIdUser(String login, String password) {
        try {
            PreparedStatement statement = manager.getConnection().
                    prepareStatement("SELECT auth_id FROM AUTHORIZATION WHERE login = ? AND  password = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("auth_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int createUser(String login, String password) {
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement
                    ("INSERT INTO AUTHORIZATION (login, password) VALUES (?, ?)");
            statement.setString(1, login);
            statement.setString(2, password);
            if (statement.executeUpdate() == 1) {
                return getIdUser(login, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int createInfoUser(int id, String name, String family, String patronymic, String city) {
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement
                    ("INSERT INTO user (first_name, family, patronymic, city, fk_auth) VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, name);
            statement.setString(2, family);
            statement.setString(3, patronymic);
            statement.setString(4, city);
            statement.setInt(5, id);
            if (statement.executeUpdate() == 1) {
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
