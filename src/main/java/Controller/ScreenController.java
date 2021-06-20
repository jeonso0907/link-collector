package Controller;

import Model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.Optional;

public class ScreenController {

    public ScreenController(String nextScene) {
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource(nextScene));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Model m = new Model();
        Stage st = m.getStage();
        st.setScene(scene);
    }

    public static void getSignupDialog(HashMap<Boolean, String> signupResult) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Signup Result");
        alert.setHeaderText("Signup Result");

        boolean bResult = (boolean) signupResult.keySet().toArray()[0];
        String message = (String) signupResult.values().toArray()[0];

        alert.setContentText(message);

        if (bResult) {
            ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Login");
        } else {
            ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Back");
        }

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK && bResult) {
            SignupController.doneSignup();
        }
    }

}
