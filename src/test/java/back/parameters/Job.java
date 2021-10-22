package back.parameters;

public class Job {
    private int id;
    private String title;
    private String description;
    private String price;
    private String user;
    private int noOfComments;

    public Job() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getUser() {
        return user;
    }

    public int getNoOfComments() {
        return noOfComments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setNoOfComments(int noOfComments) {
        this.noOfComments = noOfComments;
    }
}
