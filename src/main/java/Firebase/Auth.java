package Firebase;

import Model.Link;
import Model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Auth {

    private Firestore db;

    public Auth(Firestore fireStore) throws IOException {
        db = fireStore;
    }

    public boolean isUser(User user) {
        Boolean isUser = false;
        ApiFuture<QuerySnapshot> userLinkCollection = db.collection("user").get();
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
                if (document.getString("pw").equals(user.getPw())) {
                    System.out.println("Email Found: Login success");
                    isUser = true;
                }
            }
        }

        return isUser;
    }


}
