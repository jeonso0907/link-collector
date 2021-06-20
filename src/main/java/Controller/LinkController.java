package Controller;

import Firebase.Firebase;
import Object.Link;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkController {

    private static List<Link> linkList = new ArrayList<Link>();
    private static Firebase fireBase;


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

}
