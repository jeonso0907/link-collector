package Controller;

import Object.Link;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class ListEditController {

    private static ObservableList<Link> linkEditList = FXCollections.observableArrayList();
    private static ObservableList<String> linkTitle = FXCollections.observableArrayList();

    @FXML
    private ListView linkList;
    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button doneBtn;

    public void initialize() {

        ObservableList<String> editTitleList = linkTitle;

        linkList.setItems(editTitleList);

        addBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Link link = ScreenController.getEditDialog("Add", linkList);
                editTitleList.add(link.getTitle());
            }
        });

        editBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Link link = ScreenController.getEditDialog("Edit", linkList);
            }
        });

         doneBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent mouseEvent) {
                 new ScreenController("View/LinkList.fxml");
             }
         });
    }

    public static void setEditList(ObservableList<Link> finalLinkList) {
        linkEditList = finalLinkList;
        linkTitle = FXCollections.observableArrayList();
        for (Link link : linkEditList) {
            linkTitle.add(link.getTitle());
        }
    }

    public static ObservableList<Link> getEditList() {
        return linkEditList;
    }

}
