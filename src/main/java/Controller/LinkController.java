package Controller;

import Firebase.Auth;
import Firebase.Data;
import Firebase.Firebase;
import Model.Link;
import Model.User;
import View.MainFrame2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkController {

    private static List<Link> linkList = new ArrayList<Link>();
    private static Firebase fireBase;
    private static MainFrame2 mainFrame;

    public static void initializeList() {

//        Data linkData = null;
//        try {
//            linkData = new Data();
//        } catch (IOException e) {
//
//        }
//        linkList = linkData.getData();

//        Homepage.setJList(linkList);
    }

//    public static Boolean isAuth(User user) {
//
//        return Auth.isAuth(user.getId(), user.getPw());
//
//    }

    public static void initializeFirebase() throws IOException {
        fireBase = new Firebase();
    }

    public static Firebase getFirebase() {
        return fireBase;
    }

    public static void initializeMainFrame() {
        mainFrame = new MainFrame2();
    }

    public static MainFrame2 getMainFrame() {
        return mainFrame;
    }
}
