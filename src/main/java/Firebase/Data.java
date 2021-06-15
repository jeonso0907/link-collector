package Firebase;

import Model.Link;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Data {

    private Firestore db;

    public Data(Firestore fireStore) throws IOException {
        db = fireStore;
    }

    public List<Link> getData() {
        List<Link> linkList = new ArrayList<>();

        ApiFuture<QuerySnapshot> userLinkCollection = db.collection("jeon.193").get();

        List<QueryDocumentSnapshot> documents = null;
        try {
            documents = userLinkCollection.get().getDocuments();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        } catch (ExecutionException e) {
            System.out.println("Execution Exception");
        }

        for (DocumentSnapshot document : documents) {
            if (document.getId().substring(0,4).equals("Link")) {
                System.out.println("Getting Link: " + document.getId());
                Link link = new Link(document.getString("Link"), document.getString("Title"));
                System.out.println(link.getLink() + " " + link.getTitle());
                linkList.add(link);
            }
        }

        return linkList;
    }

    public void checkDuplicate(String id, String pw) {

    }

    public void setData() throws IOException, ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("users").document("alovelace");
        // Add document data  with id "alovelace" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Ada");
        data.put("last", "Lovelace");
        data.put("born", 1815);
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + result.get().getUpdateTime());
    }
}
