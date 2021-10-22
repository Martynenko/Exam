package back.freelanceapitest;

import back.freelanceapi.*;
import back.parameters.Job;
import back.parameters.SignIn;
import back.parameters.SignUp;
import back.parameters.UserDataUpdate;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static back.freelanceapi.AuthControllerApi.signInParameters;
import static back.freelanceapi.AuthControllerApi.signOutParameters;
import static back.freelanceapi.UserControllerApi.userDataUpdateParameters;

public class FreelanceApiTest {
    @Test
    public void signUpTest() throws IOException {
        SignUp authSignup = signOutParameters("artem.martynenko@privatban", "qwerty123456", "qwerty123456");
        String jsonObject = new Gson().toJson(authSignup);
        JSONObject responseJson = new JSONObject(AuthControllerApi.signUp(jsonObject));
        String message = responseJson.getString("message");
        Assert.assertEquals(message, "User registered successfully");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void signInTest() throws IOException {
        SignIn authSignin = signInParameters("artem.martynenko@privatbank.ua", "qwerty123456");
        String jsonObject = new Gson().toJson(authSignin);
        JSONObject responseJson = new JSONObject(AuthControllerApi.signIn(jsonObject));
        boolean success = responseJson.getBoolean("success");
        Assert.assertTrue(success, "Signin true");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void userUpdateDataTest() throws IOException {
        UserDataUpdate userDataUpdate = userDataUpdateParameters(0, "artem.martynenko@privatbank.ua", "Artem", "Martynenko");
        String jsonObject = new Gson().toJson(userDataUpdate);
        JSONObject responseJson = new JSONObject(UserControllerApi.userDataUpdate(jsonObject));
        String name = responseJson.getString("name");
        String lastname = responseJson.getString("lastname");
        Assert.assertEquals(name, "Artem");
        Assert.assertEquals(lastname, "Martynenko");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void userIdTest() throws IOException {
        JSONObject responseJson = new JSONObject(UserControllerApi.userId(126));
        int id = responseJson.getInt("id");
        String username = responseJson.getString("username");
        Assert.assertEquals(id, 126);
        Assert.assertEquals(username, "artem.martynenko@privatbank.ua");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void userTest() throws IOException {
        JSONObject responseJson = new JSONObject(UserControllerApi.getUser());
        int id = responseJson.getInt("id");
        String username = responseJson.getString("username");
        Assert.assertEquals(id, 126);
        Assert.assertEquals(username, "artem.martynenko@privatbank.ua");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void createJobTest() throws IOException {
        Job job = JobControllerApi.jobCreateParameters(0, "QA", "Testing software", "15000", "artem.martynenko@privatbank.ua", 0);
        String jsonObject = new Gson().toJson(job);
        JSONObject responseJson = new JSONObject(JobControllerApi.jobCreate(jsonObject));
        String title = responseJson.getString("title");
        String description = responseJson.getString("description");
        int price = responseJson.getInt("price");
        String user = responseJson.getString("user");
        Assert.assertEquals(title, "QA");
        Assert.assertEquals(description, "Testing software");
        Assert.assertEquals(price, 15000);
        Assert.assertEquals(user, "Artem Martynenko");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void deleteJobTest() throws IOException {
        JSONObject responseJson = new JSONObject(JobControllerApi.jobDelete(""));
        String message = responseJson.getString("message");
        Assert.assertEquals(message, "Job is deleted");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void jobIdTest() throws IOException {
        JSONObject responseJson = new JSONObject(JobControllerApi.getJobId(477));
        int id = responseJson.getInt("id");
        String title = responseJson.getString("title");
        String description = responseJson.getString("description");
        int price = responseJson.getInt("price");
        String user = responseJson.getString("user");
        Assert.assertEquals(id, 477);
        Assert.assertEquals(title, "QA");
        Assert.assertEquals(description, "Testing software");
        Assert.assertEquals(price, 15000);
        Assert.assertEquals(user, "Artem Martynenko");
        System.out.println("Response - " + responseJson);
        System.out.println(id);
    }

    @Test
    public void jobTest() throws IOException {
        JSONArray responseJson = new JSONArray(JobControllerApi.getJob());
        System.out.println(responseJson);
        int id = responseJson.getJSONObject(0).getInt("id");
        int id2 = responseJson.getJSONObject(1).getInt("id");
        int id3 = responseJson.getJSONObject(2).getInt("id");
        Assert.assertEquals(id, 477);
        Assert.assertEquals(id2, 465);
        Assert.assertEquals(id3, 464);
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void jobAllTest() throws IOException {
        JSONArray responseJson = new JSONArray(JobControllerApi.getAllJob());
        System.out.println(responseJson);
        int id = responseJson.getJSONObject(0).getInt("id");
        int id2 = responseJson.getJSONObject(1).getInt("id");
        int id3 = responseJson.getJSONObject(2).getInt("id");
        Assert.assertEquals(id, 509);
        Assert.assertEquals(id2, 507);
        Assert.assertEquals(id3, 505);
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void createCommentTest() throws IOException {
        JSONObject responseJson = new JSONObject(CommentControllerApi.commentParameters(0, "My comment", "artem.martynenko@privatbank.ua", "21.10.2021"));
        String message = responseJson.getString("message");
        String username = responseJson.getString("username");
        Assert.assertEquals(message, "My comment");
        Assert.assertEquals(username, "artem.martynenko@privatbank.ua");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void allCommentTest() throws IOException {
        JSONArray responseJson = new JSONArray(CommentControllerApi.getComment(477));
        System.out.println(responseJson);
        String message = responseJson.getJSONObject(0).getString("message");
        String username = responseJson.getJSONObject(0).getString("username");
        String message2 = responseJson.getJSONObject(1).getString("message");
        String username2 = responseJson.getJSONObject(1).getString("username");
        Assert.assertEquals(message, "My comment");
        Assert.assertEquals(username, "artem.martynenko@privatbank.ua");
        Assert.assertEquals(message2, "Mycomment");
        Assert.assertEquals(username2, "artem.martynenko@privatbank.ua");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void imageUploadTest() throws IOException {
        JSONObject responseJson = new JSONObject(ImageControllerApi.imageUpload("", new File("D:/qwer.png")));
        String message = responseJson.getString("message");
        Assert.assertEquals(message, "User image was uploaded");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void imageIdTest() throws IOException {
        JSONObject responseJson = new JSONObject(ImageControllerApi.getImageId(126));
        String name = responseJson.getString("name");
        int id = responseJson.getInt("id");
        Assert.assertEquals(name, "qwer.png");
        Assert.assertEquals(id, 110);
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void imageTest() throws IOException {
        JSONObject responseJson = new JSONObject(ImageControllerApi.getImage());
        String name = responseJson.getString("name");
        int id = responseJson.getInt("id");
        Assert.assertEquals(name, "qwer.png");
        Assert.assertEquals(id, 110);
        System.out.println("Response - " + responseJson);
    }

}

