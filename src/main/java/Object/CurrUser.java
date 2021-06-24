package Object;

import Object.User;
import Object.Link;
import javafx.collections.ObservableList;

public class CurrUser {

    private User currUser;
    private ObservableList<Link> userLink;

    public CurrUser(User user, ObservableList<Link> userLink) {
        this.currUser = user;
        this.userLink = userLink;
    }

    public User getCurrUser() {
        return currUser;
    }

    public void setCurrUser(User currUser) {
        this.currUser = currUser;
    }

    public ObservableList<Link> getUserLink() {
        return userLink;
    }

    public void setUserLink(ObservableList<Link> userLink) {
        this.userLink = userLink;
    }
}
