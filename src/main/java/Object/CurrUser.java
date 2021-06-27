package Object;

import Object.User;
import Object.Link;
import javafx.collections.ObservableList;

public class CurrUser {

    private User currUser;
    private static ObservableList<Link> userLink;

    private static CurrUser currUserObj = null;

    public CurrUser(User user, ObservableList<Link> userLink) {
        this.currUser = user;
        this.userLink = userLink;
    }

    public static CurrUser CurrUserObject (User user, ObservableList<Link> userLink) {
        if (currUserObj == null) {
            currUserObj = new CurrUser(user, userLink);
        } else {
            currUserObj.currUser = user;
            currUserObj.userLink = userLink;
        }
        return currUserObj;
    }

    public static User getCurrUser() {
        return currUserObj.currUser;
    }

    public void setCurrUser(User currUser) {
        this.currUser = currUser;
    }

    public static ObservableList<Link> getUserLink() {
        return currUserObj.userLink;
    }

    public static void setUserLink(ObservableList<Link> userLink) {
        currUserObj.userLink = userLink;
    }
}
