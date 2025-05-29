package ui;

import dao.ConnectionManager;
import service.UserService;

public class UserView {
    private final UserService service = new UserService();

    private final ConnectionManager connectionManager = new ConnectionManager(); //UserView (UI) accediendo a ConnectionManager (DAO)

    public void showUser(String name) {
        service.getUserInfo(name);
    }
}

