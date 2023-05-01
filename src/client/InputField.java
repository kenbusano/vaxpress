//InputField.java

package client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InputField {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button proceedBtn;
    
    @FXML
    private void checkFields() {
        boolean allFieldsFilled = !usernameField.getText().isEmpty() 
        && !passwordField.getText().isEmpty();

        proceedBtn.setDisable(!allFieldsFilled);
    }
}
