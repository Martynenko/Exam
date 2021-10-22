package back.freelanceapi;

import back.parameters.UserDataUpdate;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UserControllerApi {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api";

    public static UserDataUpdate userDataUpdateParameters(int id, String username, String name, String lastname) {

        UserDataUpdate userDataUpdate = new UserDataUpdate();
        userDataUpdate.setId(id);
        userDataUpdate.setUsername(username);
        userDataUpdate.setName(name);
        userDataUpdate.setLastname(lastname);
        return userDataUpdate;
    }

    public static String userDataUpdate(String jsonObject) throws IOException {

        RequestBody requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgxNDQ1MCwiZXhwIjoxNjM0ODE4MDUwfQ.NuSqfmO8XW2gxpyhtihFoz4ebtMSXkGrDCl7GBs_qX7baCqt5sRIGq3iR4_yeeqELxL8yd-Lldl_nZPNic08BA")
                .post(requestBody)
                .url(baseUrl + "/user/update")
                .build();
        System.out.println(request);
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();

    }

    public static String userId(int userId) throws IOException {

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgxNDQ1MCwiZXhwIjoxNjM0ODE4MDUwfQ.NuSqfmO8XW2gxpyhtihFoz4ebtMSXkGrDCl7GBs_qX7baCqt5sRIGq3iR4_yeeqELxL8yd-Lldl_nZPNic08BA")
                .get()
                .url(baseUrl + "/user/"+userId)
                .build();
        System.out.println(request);
             OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();

    }
    public static String getUser() throws IOException {

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgxNDQ1MCwiZXhwIjoxNjM0ODE4MDUwfQ.NuSqfmO8XW2gxpyhtihFoz4ebtMSXkGrDCl7GBs_qX7baCqt5sRIGq3iR4_yeeqELxL8yd-Lldl_nZPNic08BA")
                .get()
                .url(baseUrl + "/user/")
                .build();
        System.out.println(request);
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();
    }


}
