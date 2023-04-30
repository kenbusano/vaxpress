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
    String URL = "jdbc:mysql://localhost/vrms-client";
    String user = "root";
    String password = "";

    public Tunnel() {}

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //cj driver is latest :)
            databaseLink = (Connection) DriverManager.getConnection(URL, user, password);
            System.out.println("iloveyou");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("mabuhay");
        }
    }
}