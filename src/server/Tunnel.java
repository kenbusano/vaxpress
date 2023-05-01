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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tunnel {
    public Connection databaseLink;
    String URL = "jdbc:mysql://localhost:3306/vrms-client";
    String user = "root";
    String password = "";
    private static final String SELECT_QUERY = "SELECT * FROM user_client";
    ResultSet rst = null;

    public Tunnel() {
    }

    public void connect() {
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            System.out.println(connection);
            // Class.forName("com.mysql.cj.jdbc.Driver"); //cj driver is latest :)
            // databaseLink = (Connection) DriverManager.getConnection(URL, user, password);

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);

            System.out.println(preparedStatement);
            rst = preparedStatement.executeQuery();
            
            System.out.println("Id\t\tUsername\t\tPassword");

            while(rst.next()) {
                System.out.print(rst.getInt(1));
                System.out.print("\t\t"+rst.getString(2));
                System.out.print("\t\t"+rst.getString(3));
                System.out.println();
            }

        } catch (SQLException e) {
            printSQLException(e);
        } 
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
