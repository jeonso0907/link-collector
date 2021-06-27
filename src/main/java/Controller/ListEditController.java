package Controller;

import Object.Link;
import Object.CurrUser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.Currency;

public class ListEditController {

    private static ObservableList<Link> linkEditList = FXCollections.observableArrayList();
    private static ObservableList<String> linkTitle = FXCollections.observableArrayList();
    private Link selectedLink;

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

        linkList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int selectedIndex = linkList.getSelectionModel().getSelectedIndex();
                System.out.println("LINK LIST: " + linkEditList.get(selectedIndex).getTitle());
                String selectedTitle = editTitleList.get(selectedIndex);
                for (Link link : CurrUser.getUserLink()) {
                    if (link.getTitle().equals(selectedTitle)) {
                        selectedLink = link;
                    }
                }
            }
        });

        addBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Link link = ScreenController.getEditDialog("Add", linkList);
                if( !link.getTitle().equals("Cancel")) {
                    editTitleList.add(link.getTitle());
                }
            }
        });

        editBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (selectedLink != null) {
                    ScreenController.setEditingLink(selectedLink);
                    Link link = ScreenController.getEditDialog("Edit", linkList);
                    if (!link.getTitle().equals("Cancel")) {
                        editTitleList.remove(selectedLink.getTitle());
                        editTitleList.add(link.getTitle());
                        selectedLink = link;
                    }
                }
            }
        });

        deleteBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (selectedLink != null) {
                    boolean isDeleted = ScreenController.getDeleteDialog(selectedLink);
                    if (isDeleted) {
                        editTitleList.remove(selectedLink.getTitle());
                        selectedLink = null;
                    }
                }
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
