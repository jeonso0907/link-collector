package Firebase;

import Object.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Auth {

    public static boolean isUser(User user) {
        Firestore db = Firebase.getDb();
        boolean isUser = false;
        ApiFuture<QuerySnapshot> userLinkCollection = db.collection("user").get();
        List<QueryDocumentSnapshot> documents = null;
        try {
            documents = userLinkCollection.get().getDocuments();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        } catch (ExecutionException e) {
            System.out.println("Execution Exception");
        }

        assert documents != null;
        for (DocumentSnapshot document : documents) {
            if (document.getId().equals(user.getId())) {
                if (Objects.equals(document.getString("pw"), user.getPw())) {
                    System.out.println("Email Found: Login success");
                    isUser = true;
                }
            }
        }

        return isUser;
    }

    public static boolean signupNewUser(User user) {

        Firestore db = Firebase.getDb();

        Map<String, Object> docData = new HashMap<>();
        docData.put("name", user.getName());
        docData.put("pw", user.getPw());
        // Add a new document (asynchronously) in collection "cities" with id "LA"
        ApiFuture<WriteResult> future = db.collection("user").document(user.getId()).set(docData);

        return true;
    }

    public static void initializeLinkData(User user) {

        Firestore db = Firebase.getDb();

        db.collection("link").document(user.getId()).set(new HashMap<>());

    }

}
