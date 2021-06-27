package Firebase;

import Controller.LinkListController;
import Object.CurrUser;
import Object.User;
import Object.Link;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Data {

    private Firestore db;

    public Data() {};

    public Data(Firestore fireStore) throws IOException {
        db = fireStore;
    }

    public ObservableList<Link> getData(User user) {
        db = Firebase.getDb();
        ObservableList<Link> linkList = FXCollections.observableArrayList();

        ApiFuture<QuerySnapshot> userLinkCollection = db.collection("link").get();

        List<QueryDocumentSnapshot> documents = null;
        try {
            documents = userLinkCollection.get().getDocuments();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        } catch (ExecutionException e) {
            System.out.println("Execution Exception");
        }

        for (DocumentSnapshot document : documents) {
            if (document.getId().equals(user.getId())) {
                System.out.println("Getting Link: " + document.getId());
                for (Map.Entry<String, Object> linkData : document.getData().entrySet()) {
                    Link link = new Link(linkData.getKey(), linkData.getValue().toString());
                    linkList.add(link);
                    System.out.println("GETTING LINK: " + linkData.getKey() + ", "+ linkData.getValue().toString());
                }
//                Link link = new Link(document.getData(user.getId()), document.get(document.getId()).toString());
//                System.out.println(link.getLink() + " " + link.getTitle());
//                linkList.add(link);
            }
        }

        return linkList;
    }

    public void checkDuplicate(String id, String pw) {

    }

    public void setData(Link link) throws ExecutionException, InterruptedException {
        User user = CurrUser.getCurrUser();
        db = Firebase.getDb();
        DocumentReference docRef = db.collection("link").document(user.getId());
        // Add document data  with id "alovelace" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put(link.getTitle(), link.getLink());
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.update(data);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + result.get().getUpdateTime());

        ObservableList<Link> links = CurrUser.getUserLink();
        links.add(link);
        CurrUser.setUserLink(links);
    }

    public boolean updateData(Link editLink, Link newLink) throws ExecutionException, InterruptedException {
        User user = CurrUser.getCurrUser();
        db = Firebase.getDb();

        if (editLink.getTitle().equals(newLink.getTitle())
            && editLink.getLink().equals(newLink.getLink())) {
            return false;
        }

        DocumentReference docRef = db.collection("link").document(user.getId());

        Map<String, Object> updates = new HashMap<>();
        updates.put(editLink.getTitle(), FieldValue.delete());
        ApiFuture<WriteResult> deleteCurr = docRef.update(updates);

        updates.put(newLink.getTitle(), newLink.getLink());
        ApiFuture<WriteResult> addNew = docRef.update(updates);
        return true;
    }

    public void removeData(Link deleteLink) {
        User user = CurrUser.getCurrUser();
        db = Firebase.getDb();

        DocumentReference docRef = db.collection("link").document(user.getId());

        Map<String, Object> delete = new HashMap<>();
        delete.put(deleteLink.getTitle(), FieldValue.delete());
        docRef.update(delete);
    }
}
