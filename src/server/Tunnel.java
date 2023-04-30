package server;

/**
 *  2023 - DEV
 *  Developer: Kenneth Obsequio
 *  GitHub: https://github.com/kenbusano
 *  License: MIT
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tunnel {
    public Connection databaseLink;
    String URL = "jdbc:mysql://localhost/mysql";
    String user = "root";
    String password = "";

    public Tunnel() {}

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = (Connection) DriverManager.getConnection(URL, user, password);
            System.out.println("iloveyou");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("mabuhay");
        }
    }
}
