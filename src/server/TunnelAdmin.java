package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TunnelAdmin {
    public Connection dataAdmin;
    String URL = "jdbc:mysql://localhost:3306/vrms-client";
    String user = "root";
    String password = "";
    private static final String SELECT_QUERY = "SELECT * FROM `user_admin` WHERE admin_name AND admin_pass";
    
    public void connectAdmin() {
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            System.out.println(connection);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public static boolean AdminVal(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vrms-client", "root", "");
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
            return false;
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
