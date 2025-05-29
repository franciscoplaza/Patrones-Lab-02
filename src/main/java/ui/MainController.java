package ui;

import service.UserService;

public class MainController {
    private final UserService userService = new UserService();
//    private UserView userView = new UserView();

    public void run() {
        userService.registerUser("Alice");
    }
}