package org.example.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
public static Connection connection;

    private static final String DB_Path = "jdbc:mysql://localhost:3306/labs_kpi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "speltor03092305";

    public Database() throws SQLException {
        connection = DriverManager.getConnection(DB_Path, USER, PASSWORD);
    }

}
