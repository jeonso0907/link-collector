package Object;

import javafx.collections.ObservableList;

public class Link {
    private String title;
    private String link;

    public Link(String link, String title) {
        this.link = link;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
