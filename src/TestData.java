import javafx.event.ActionEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class TestData {
    public void connectButton(ActionEvent event) {
        ServerTunnel connectNow = new ServerTunnel();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT * FROM test-vrms.test";

        try {
            Statement statement = (Statement) connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}