package Controller;

import Firebase.Data;
import Object.CurrUser;
import Object.User;
import Object.Link;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class LinkListController {

    // LINK LIST NOW HAS AUTH OVER THIS USER
    // ALWAYS CALL LINK LIST CONTROLLER IN ORDER TO CALL THE CURRENT LOG IN USER
    private static CurrUser loginUser;

    @FXML
    private ListView linkList;
    @FXML
    private Button launchBtn;
    @FXML
    private Button signOutBtn;
    @FXML
    private Button editBtn;

    public static void setLoginUser(User user) {
        ObservableList<Link> links = FXCollections.observableArrayList();
        loginUser = new CurrUser(user, links);
    }

    public static User getLoginUser() {
        return loginUser.getCurrUser();
    }

    public void initialize() {

        Data data = new Data();
        ObservableList<Link> links = data.getData(loginUser.getCurrUser());
        ObservableList<String> linksString = FXCollections.observableArrayList();

        for (Link link : links) {
            linksString.add(link.getTitle());
        }
        linkList.setItems(linksString);

        editBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ListEditController.setEditList(links);
                new ScreenController("View/ListEdit.fxml");
            }
        });

        signOutBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                new ScreenController("View/Login.fxml");
            }
        });
    }
}
