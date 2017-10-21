package ivan1.services;

public interface RegistrationService {
    int newRegistration(String login, String password, String name, String family, String patronymic, String city);
}
