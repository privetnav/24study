package ivan1.services;

import ivan1.db.dao.UserDAO;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public int newRegistration(String login, String password, String name, String family, String patronymic, String city) {
        int idUser = registationUser(login, password);
        return UserDAO.createInfoUser(idUser, name, family, patronymic, city);
    }

    private int registationUser(String login, String password) {
        return UserDAO.createUser(login, PasswordEncoder.encode(password));
    }
}
