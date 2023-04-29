import java.sql.Connection;
import java.sql.DriverManager;

public class ServerTunnel {
    public Connection databaseLink;

    public Connection getConnection() {
        String tableName = "test-vrms";
        String usn = "";
        String pwd = "";
        String url = "jdbc:mysql://localhost/" + tableName + "?useSSL=false&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, usn, pwd);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
