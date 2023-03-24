import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MainSceneController {

    @FXML
    private TextField message;

    @FXML
    void btnOK(ActionEvent event) {
        Stage mainWindow = (Stage) message.getScene().getWindow();
        String title = message.getText();
        mainWindow.setTitle(title);
    }

}
