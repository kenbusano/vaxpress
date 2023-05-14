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
    private static final String SELECT_QUERY = "SELECT * FROM user_admin";
    
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
    public boolean isAdminUser(String username, String password) throws SQLException {
        boolean isAdmin = false;
        String sql = "SELECT COUNT(*) FROM user_admin WHERE admin_name AND admin_pass";
        try (Connection conn = DriverManager.getConnection(URL, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    isAdmin = true;
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error checking admin user credentials: " + ex.getMessage());
            throw ex;
        }
        return isAdmin;
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
