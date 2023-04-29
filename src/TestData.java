/* may error d2 */

import javafx.event.ActionEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class TestData {
    public void connectButton(ActionEvent event) {
        ServerTunnel connectNow = new ServerTunnel();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "sql command here";

        try {
            Statement statement = (Statement) connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
