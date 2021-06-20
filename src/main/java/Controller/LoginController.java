package Controller;

import Object.User;
import Firebase.Auth;
import Model.Model;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

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
                Auth.isUser(user);
                System.out.println("로그인 성공");
            }
        });

        signupBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                new ScreenController("View/Signup.fxml");
            }
        });
    }

}
