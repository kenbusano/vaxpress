
/**
 *  2023 - DEV
 *  Developer: Kenneth Obsequio
 *  GitHub: https://github.com/kenbusano
 *  License: MIT
 */

import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.Tunnel;
import javafx.scene.layout.AnchorPane;

public class App extends Application {
    // Opening the application basics
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception {
        // Specifying to load FXML document
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "src/Landing.fxml";
        try (FileInputStream fxmlStream = new FileInputStream(fxmlDocPath)) {
            AnchorPane root = (AnchorPane) loader.load(fxmlStream);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("VAXPress - Vaccine Record Management System");
            stage.setResizable(false); // Window Sizing Prevention
            stage.show();
            // Simple Database Connecting
            Tunnel tunnel = new Tunnel();
            tunnel.connect();
             
        } catch (IOException e) {
            System.err.println("Failed to load FXML file: " + e.getMessagge());
        }
    }
}
