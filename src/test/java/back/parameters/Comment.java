package back.parameters;

public class Comment {
    private int id;
    private String message;
    private String username;
    private String commentDate;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
}
