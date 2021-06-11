package Model;

import Controller.LinkController;
import Firestore.Data;
import View.Homepage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Model {
    public static void main(String[] args) {
        LinkController.initializeList();

        Homepage homepage = new Homepage();
        homepage.setVisible(true);




    }
}
