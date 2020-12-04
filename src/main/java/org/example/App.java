package org.example;


import org.example.controller.Controller;
import org.example.model.db.Database;


import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        try {
            Database database = new Database();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new Controller().run();
    }
}
