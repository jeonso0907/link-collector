package Controller;

import Firestore.Data;
import Model.Link;
import View.Homepage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkController {

    private static List<Link> linkList = new ArrayList<Link>();

    public static void initializeList() {

        Data linkData = null;
        try {
            linkData = new Data();
        } catch (IOException e) {

        }
        linkList = linkData.getData();

        Homepage.setJList(linkList);
    }

}