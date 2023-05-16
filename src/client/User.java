package client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.stage.Stage;

public class User {
    @FXML
    private Button userProfile;

    @FXML
    private Button userHome;

    @FXML
    private Button logUser;

    @FXML
    private void userAct(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/ClientProfile.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) userProfile.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void userCome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/ClientPanel.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) userHome.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goodBye (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) logUser.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
