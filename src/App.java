import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
 
public class App extends Application {
    public Parent createContent() {
        Text text = new Text("tangina niyooo");
        text.getStyleClass().add("text");
        return new StackPane(text);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent rootNode = createContent();
        Scene scene = new Scene(rootNode, 300, 300);
        scene.getStylesheets().add("resources/stylesheet.css");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}