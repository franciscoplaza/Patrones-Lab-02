package dao;

//import configuration.Configuration;

public class ConnectionManager {
//    private Configuration config = new Configuration(); //ConnectionManager (DAO) accediendo a dependencia no declarada en el modelo.
    public void connect() {
        System.out.println("Database connected.");
    }
}

