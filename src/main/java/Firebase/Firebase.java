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
                new FileInputStream("/Users/sooyoung/Desktop/link-collector-41e61-firebase-adminsdk-ilih0-6179a8c8ef.json");

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
        data.getData();
    }

}
