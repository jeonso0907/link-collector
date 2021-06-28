package Model;

import Firebase.Firebase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Model extends Application{

    private static Stage stage;

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        new Firebase();

        Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("View/Login.fxml"));
        Scene scene = new Scene(root);
        setStage(stage);

        stage.setTitle("Link Collector");

        // Set window resizeable to false
        stage.setResizable(false);
        stage.setScene(scene);

        // Hide the title bar
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        stage.show();
 
        // Display the window on top of the screen
//        stage.setAlwaysOnTop(true);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
