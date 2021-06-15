package Model;

import Controller.LinkController;
import Firebase.Auth;
import Firebase.Data;
import Firebase.Firebase;
import View.MainFrame2;

import java.io.IOException;

public class Model {

    public static void main(String[] args) throws IOException {

        LinkController.initializeList();
        LinkController.initializeFirebase();
        LinkController.initializeMainFrame();


    }


}
