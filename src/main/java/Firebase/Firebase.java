package Firebase;

import Object.User;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class Firebase {

    private static Firestore db;

    public Firebase() throws IOException {


        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/FirestoreKey/firestore.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

//
//        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(credentials)
//                .setProjectId("link-collector-41e61")
//                .build();
//        FirebaseApp.initializeApp(options);

        this.db = FirestoreClient.getFirestore();
    }

    public static Firestore getDb() {
        return db;
    }

    public void setDb(Firestore db) {
        this.db = db;
    }

    public void getData() throws IOException {
        Data data = new Data(this.db);
    }

}
