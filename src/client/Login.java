/**
 *  2023 - DEV
 *  Developer: Kenneth Obsequio
 *  GitHub: https://github.com/kenbusano
 *  License: MIT
 */

package client;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import server.TunnelAdmin;

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
    private void handleRegister(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/Modal.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        Stage stage = (Stage) registerBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void Admin() {
        String username = userField.getText();
        String password = passField.getText();
    
        try {
            if (TunnelAdmin.AdminVal(username, password)) {
                System.out.println("ayan gumagana na ");
            } else {
                System.out.println("gagoooo mali");
            }
        } catch (SQLException e) {
            TunnelAdmin.printSQLException(e);
        }
    }
    @FXML
    private void loginNow() {
        Admin();
    }
    public void initialize() {
        userField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                passField.requestFocus();
            }
        });

        passField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Admin();
            }
        });
    }
}

