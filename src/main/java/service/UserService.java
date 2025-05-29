package service;

import dao.UserRepository;
//import ui.LoginController;

public class UserService {
    private final UserRepository repository = new UserRepository();

//    private final LoginController loginController = new LoginController(); //UserService (Service) accediendo a LoginController (UI).

    public void registerUser(String name) {
        repository.save(name);
    }

    public void getUserInfo(String name) {
        System.out.println("User info for: " + name);
    }
}

