package server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class TestData {

    @FXML
    private Label stringLabel;
    
    public void connectButton(ActionEvent event) {
        ServerTunnel connectNow = new ServerTunnel();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT * FROM `bad-test`";

        try {
            Statement statement = (Statement) connectDB.createStatement();
            ResultSet queryOutput = ((java.sql.Statement) statement).executeQuery(connectQuery);

            while (queryOutput.next()) {
                stringLabel.setText(queryOutput.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
