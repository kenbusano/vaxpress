import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class App extends Application {
    //Opening the FXML basics
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "src/Landing.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("VAXPress - Vaccine Record Management System");
        stage.show();
    }
}