package admin;

/**
 *  2023 - DEV
 *  Developer: Kenneth Obsequio
 *  GitHub: https://github.com/kenbusano
 *  License: MIT
 */

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Dashboard {
    @FXML
    private Button logOut;

    @FXML
    private Button vaccReq;

    @FXML
    private Button vaccHome;

    @FXML
    private Button vaccRequest;

    @FXML
    private void adminHome (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/AdminPanel.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) logOut.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void vaccine (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/AdminVacc.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) logOut.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void addVaccine (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/AdminFillUp.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) logOut.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void signOut (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/client/resources/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) logOut.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        //load
        System.out.println("An administrator has been offline!!");
    }
}
