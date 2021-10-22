package back.freelanceapi;

import back.parameters.Job;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JobControllerApi {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api";
    private static int jobId = 303;

    public static Job jobCreateParameters(int id, String title, String description, String price, String user, int noOfComments) {
        Job job = new Job();
        job.setId(id);
        job.setTitle(title);
        job.setDescription(description);
        job.setPrice(price);
        job.setUser(user);
        job.setNoOfComments(noOfComments);
        return job;
    }

    public static String jobCreate(String jsonObject) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgyMDE4MCwiZXhwIjoxNjM0ODIzNzgwfQ.ZnE5vDza55U-Virciwpj3XamwZdypStoGQKbnDnMjYmzWopWQc_crl-MF2A_3wg-N9eqE7KIRy-hUB1lLOoFZA")
                .post(requestBody)
                .url(baseUrl + "/job/create")
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();
    }

    public static String jobDelete(String jsonObject) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgyMDE4MCwiZXhwIjoxNjM0ODIzNzgwfQ.ZnE5vDza55U-Virciwpj3XamwZdypStoGQKbnDnMjYmzWopWQc_crl-MF2A_3wg-N9eqE7KIRy-hUB1lLOoFZA")
                .post(requestBody)
                .url(baseUrl + "/job/delete/" + jobId)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();
    }

    public static String getJobId(int jobIdForGet) throws IOException {

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgyNTQ1MiwiZXhwIjoxNjM0ODI5MDUyfQ.rkJakwCsKH3aKToLM_tAXhBxrWRrjWKbglMTPiMZmpYeu7PosIWLrOYf2dewbS4VZ2aHH2JEKtTBTUT7QQqxpQ")
                .get()
                .url(baseUrl + "/job/" + jobIdForGet)
                .build();
        System.out.println(request);
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();

    }
    public static String getJob() throws IOException {

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgyOTMxNSwiZXhwIjoxNjM0ODMyOTE1fQ.wl-9Ysp-a9rhooy_Th-tMu21HrBVsTUnxqW6gp5kzQDJiuKpB4g28STsV23vT-h2_Fp370OLBzSBCxhauEIRpw")
                .get()
                .url(baseUrl + "/job/user/jobs")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();
    }

    public static String getAllJob() throws IOException {

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDgyOTMxNSwiZXhwIjoxNjM0ODMyOTE1fQ.wl-9Ysp-a9rhooy_Th-tMu21HrBVsTUnxqW6gp5kzQDJiuKpB4g28STsV23vT-h2_Fp370OLBzSBCxhauEIRpw")
                .get()
                .url(baseUrl + "/job/all")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();
    }
}
