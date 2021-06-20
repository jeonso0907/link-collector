package Controller;

import Object.User;
import Firebase.Auth;
import Firebase.Firebase;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;

public class SignupController {


    @FXML
    private TextField nameText;
    @FXML
    private TextField emailText;
    @FXML
    private TextField pwText;
    @FXML
    private TextField pwCheckText;
    @FXML
    private Button backBtn;
    @FXML
    private Button submitBtn;

    public void initialize() {
        backBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                new ScreenController("View/Login.fxml");
            }
        });

        submitBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String name = nameText.getText();
                String email = emailText.getText();
                String pw = pwText.getText();
                String pwCheck = pwCheckText.getText();
                try {
                    ScreenController.getSignupDialog(getSignupResult(name, email, pw, pwCheck));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Failed to load the firestore database. Please contact the support team");
                }
            }
        });

    }

    private HashMap<Boolean, String> getSignupResult(String name, String email, String pw, String pwCheck) throws IOException {

        HashMap<Boolean, String> signupResult = new HashMap<>();

        // Check all fields are typed
        if (name.isBlank() || email.isBlank() || pw.isBlank() || pwCheck.isBlank()) {
            signupResult.put(false, "All fields are required");
            return signupResult;
        }

        // Check email format is correct
        if (!email.contains("@")) {
            signupResult.put(false, "Correct email is required");
            return signupResult;
        }

        // Check both passwords are same
        if (!pw.equals(pwCheck)) {
            signupResult.put(false, "Passwords do not match");
            return signupResult;
        }

        // Check the new user is already signed up or not
        User user = new User(email, pw, name);
        boolean isCurrent = Auth.isUser(user);

        if (isCurrent) {
            signupResult.put(false, "Already signed up");
        } else {
            Auth.signupNewUser(user);
            signupResult.put(true, "Signup success!");
        }

        return signupResult;
    }

    public static void doneSignup() {
        new ScreenController("View/Login.fxml");
    }

}
