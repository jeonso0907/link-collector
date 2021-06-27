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

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class LinkListController {

    // LINK LIST NOW HAS AUTH OVER THIS USER
    // ALWAYS CALL LINK LIST CONTROLLER IN ORDER TO CALL THE CURRENT LOG IN USER
    private Link selectedLink;

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
        CurrUser.CurrUserObject(user, links);
    }

    public void initialize() {

        Data data = new Data();
        ObservableList<Link> links = data.getData(CurrUser.getCurrUser());
        CurrUser.setUserLink(links);
        ObservableList<String> linksString = FXCollections.observableArrayList();

        for (Link link : links) {
            linksString.add(link.getTitle());
        }
        linkList.setItems(linksString);

        linkList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int selectedIndex = linkList.getSelectionModel().getSelectedIndex();
                String selectedTitle = linksString.get(selectedIndex);
                for (Link link : CurrUser.getUserLink()) {
                    if (link.getTitle().equals(selectedTitle)) {
                        selectedLink = link;
                    }
                }
            }
        });

        launchBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                URL url = null;

                try {
                    url = new URL(selectedLink.getLink());
                } catch (MalformedURLException e) {
                    ScreenController.getRunFailAlert(selectedLink);
                }

                boolean isRun = openWebpage(url);
                System.out.println(isRun);
                if (!isRun) {
                    ScreenController.getRunFailAlert(selectedLink);
                }

            }
        });

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

    public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        if (url != null) {
            try {
                return openWebpage(url.toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
