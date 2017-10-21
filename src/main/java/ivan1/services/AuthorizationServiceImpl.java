package ivan1.services;

import ivan1.db.dao.UserDAO;

public class AuthorizationServiceImpl implements AuthorizationService {
    //private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public Boolean auth(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        if (UserDAO.getIdUser(login, PasswordEncoder.encode(password)) != 0) {
            return true;
        }
        return false;
    }
}
