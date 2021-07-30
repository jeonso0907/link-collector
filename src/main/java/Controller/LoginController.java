package Controller;

import Object.User;
import Firebase.Auth;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField emailText;
    @FXML
    private TextField pwText;
    @FXML
    private Button loginBtn;
    @FXML
    private Button signupBtn;

    public void initialize() {

        loginBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                User user = new User(emailText.getText(), pwText.getText());
                if (Auth.isUser(user)) {
                    LinkListController.setLoginUser(user);
                    new ScreenController("View/LinkList.fxml");
                } else {
                    ScreenController.getLoginDialog();
                }
            }
        });

        signupBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                new ScreenController("View/Signup.fxml");
            }
        });
    }

    private void loginErrorStatus() {

    }

}
