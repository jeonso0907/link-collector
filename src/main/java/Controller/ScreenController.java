package Controller;

import Object.Link;
import Firebase.Data;
import Model.Model;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ScreenController {

    private static Link editLink;

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

    public static void getLoginDialog() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Login Warning");
        alert.setHeaderText("Invalid Information");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Back");
        alert.showAndWait();
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

    public static Link getEditDialog(String dialogType, ListView linkList) {
        // Create the custom dialog
        Dialog<Pair<String,String>> dialog = new Dialog<>();
        dialog.setTitle("Edit Link");
        dialog.setHeaderText("Edit Link");

        // Set the dialog icon (TODO)
        // dialog.setGraphic(new ImageView(this.getClass(0.getResource("").toString()));

        // Set the button types
        ButtonType editButtonType = new ButtonType(dialogType, ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().clear();
        dialog.getDialogPane().getButtonTypes().addAll(cancelButtonType, editButtonType);

        // Create the title and title labels and fields
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField titleText = new TextField();
        titleText.setPromptText("Link Title");

        TextField linkText = new TextField();
        linkText.setPromptText("Link");

        if (dialogType.equals("Edit")) {
            titleText.setText(editLink.getTitle());
            linkText.setText(editLink.getLink());
        }

        grid.add(new Label("Link Title: "), 0, 0);
        grid.add(titleText, 1, 0);
        grid.add(new Label("Link"), 0 , 1);
        grid.add(linkText, 1, 1);

        // Enable/Disable add/edit button depending on both fields were entered
        Node editButton = dialog.getDialogPane().lookupButton(editButtonType);
        editButton.setDisable(true);

        // Do validations
        BooleanBinding textField1Valid = Bindings.createBooleanBinding(() -> {
            if (titleText.getText().isEmpty()) {
                return false;
            }
            return true;
        }, titleText.textProperty());

        BooleanBinding textField2Valid = Bindings.createBooleanBinding(() -> {
            if (linkText.getText().isEmpty()) {
                return false;
            }
            return true;
        }, linkText.textProperty());

        editButton.disableProperty().bind(textField1Valid.not().or(textField2Valid.not()));

        dialog.getDialogPane().setContent(grid);

        // Request focus on the link title field by default
        Platform.runLater(() -> titleText.requestFocus());

        // Convert the result ot a title-link pair when the edit button is clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == editButtonType) {
                return new Pair<>(titleText.getText(), linkText.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        Link link = new Link(titleText.getText(), linkText.getText());
        AtomicBoolean isOk = new AtomicBoolean(false);
        result.ifPresent(button -> {
            isOk.set(true);
            if (dialogType.equals("Add")) {
                // Firebase add
                try {
                    Data data = new Data();
                    data.setData(link);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Update edit list view
                ObservableList<Link> linkEditList = ListEditController.getEditList();
                linkEditList.add(link);
                ListEditController.setEditList(linkEditList);
            } else if (dialogType.equals("Edit")) {
                // Firebase edit
                Data data = new Data();
                boolean isEdited = false;
                try {
                    isEdited = data.updateData(editLink, link);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isEdited) {

                }
            }
            System.out.println(button.getKey().toString());
        });
        if (!isOk.get()) {
            link.setTitle("Cancel");
        }
        return link;
    }

    public static boolean getDeleteDialog(Link selectedLink) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Delete Link");
        alert.setHeaderText("Do you really want to delete this link?");
        alert.setContentText("          Title:               " + selectedLink.getTitle() +
                             "\n          Link:               " + selectedLink.getLink());

        boolean isDeleted = false;

        alert.getDialogPane().getButtonTypes().clear();

        ButtonType deleteBtn = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getDialogPane().getButtonTypes().add(deleteBtn);
        alert.getDialogPane().getButtonTypes().add(cancelBtn);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get().getText().equals("Delete")) {
            Data data = new Data();
            data.removeData(selectedLink);
            isDeleted = true;
        }
        return isDeleted;
    }

    public static void setEditingLink(Link link) {
        editLink = link;
    }

    public static void getRunFailAlert(Link link) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Launch Failed");
        alert.setHeaderText("Launch Failed");
        alert.setContentText("Failed to launch the link: \n" +
                            link.getLink());
        alert.showAndWait();
    }

}
