package back.freelanceapi;

import back.parameters.SignIn;
import back.parameters.SignUp;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AuthControllerApi {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api";

    public static SignUp signOutParameters(String username, String password, String confirmpassword) {

        SignUp signUp = new SignUp();
        signUp.setUsername(username);
        signUp.setPassword(password);
        signUp.setConfirmPassword(confirmpassword);
        return signUp;
    }

    public static String signUp(String jsonObject) throws IOException {

        RequestBody requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .post(requestBody)
                .url(baseUrl + "/auth/signup")
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();

    }

    public static SignIn signInParameters(String username, String password) {

        SignIn signIn = new SignIn();
        signIn.setUsername(username);
        signIn.setPassword(password);
        return signIn;
    }

    public static String signIn(String jsonObject) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .url(baseUrl + "/auth/signin")
                .post(requestBody)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
//        System.out.println(response.code());
//        System.out.println("response " + response.body().toString());
//        JSONObject responseJson = new JSONObject(response.body());
//        System.out.println(responseJson.getString("token"));
        return response.string();
    }

}
