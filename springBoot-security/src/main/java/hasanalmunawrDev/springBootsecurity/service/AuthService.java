package hasanalmunawrDev.springBootsecurity.service;

public interface AuthService {
    String login(String username, String password);

    String signUp(String name, String username, String password);
}
