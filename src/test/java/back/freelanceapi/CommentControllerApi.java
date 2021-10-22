package back.freelanceapi;

import back.parameters.Comment;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CommentControllerApi {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api";
    private static int jobId = 477;

    public static Comment commentParameters(int id, String message, String username, String commentDate) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setMessage(message);
        comment.setUsername(username);
        comment.setCommentDate(commentDate);

        return comment;
    }

    public static String createComment(String jsonObject) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgzMzg3NSwiZXhwIjoxNjM0ODM3NDc1fQ.HTUABDr7VJKRz3TN0VpHEVo4f-w8krLLTVh-j9xmT_POXtgA4JX8mBqwVkSVuCyGVU9mmDhXFabPgTsXQTlV8Q")
                .post(requestBody)
                .url(baseUrl + "/comment/" + jobId + "/create")
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();
    }
    public static String getComment(int jobId) throws IOException {

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgzMzg3NSwiZXhwIjoxNjM0ODM3NDc1fQ.HTUABDr7VJKRz3TN0VpHEVo4f-w8krLLTVh-j9xmT_POXtgA4JX8mBqwVkSVuCyGVU9mmDhXFabPgTsXQTlV8Q")
                .get()
                .url(baseUrl + "/comment/" + jobId+"/all")
                .build();
        System.out.println(request);
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();

    }
}
