/**
 *  2023 - DEV
 *  Developer: Kenneth Obsequio
 *  GitHub: https://github.com/kenbusano
 *  License: MIT
 */

package client;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Login {
    @FXML
    private Button proceedBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private void proceedBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) proceedBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void loginBtnClicked(ActionEvent event) throws IOException {
        String username = userField.getText();
        String password = passField.getText();

        if (username.equals("eyelash") && password.equals("admin")) {
            System.out.println("The administrator is online!");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/resources/AdminPanel.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) userField.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (username.equals("kenbusano2003@gmail.com") && password.equals("lazy")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/ClientPanel.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) userField.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("sjidsid");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/LoginError.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void handleRegister(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/Modal.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) registerBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

