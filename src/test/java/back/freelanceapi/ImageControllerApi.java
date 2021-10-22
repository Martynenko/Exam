package back.freelanceapi;

import okhttp3.*;
import java.io.File;
import java.io.IOException;

public class ImageControllerApi {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api";
    private static int userIdForImage = 126;

    public static String imageUpload(String jsonObject, File file) throws IOException {

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(MediaType.parse("png"), file))
                .build();

        Request request = new Request.Builder()
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDkxMTMwMiwiZXhwIjoxNjM0OTE0OTAyfQ.zkypkojTY1i40ecYt7YRLyJIPrme6s329ye-rOiXxWMMCRd2KDzbREmMVSJTf5zfjrj-_8hIShVFvzBUJCPSag")
                .post(requestBody)
                .url(baseUrl + "/image/upload")
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        return response.string();
    }

    public static String getImageId(int userId) throws IOException {

        Request request = new Request.Builder()
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDkxMTMwMiwiZXhwIjoxNjM0OTE0OTAyfQ.zkypkojTY1i40ecYt7YRLyJIPrme6s329ye-rOiXxWMMCRd2KDzbREmMVSJTf5zfjrj-_8hIShVFvzBUJCPSag")
                .get()
                .url(baseUrl + "/image/" + userIdForImage)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        System.out.println(request);
        return response.string();
    }

    public static String getImage() throws IOException {

        Request request = new Request.Builder()
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJuYW1lIjpudWxsLCJpZCI6IjEyNiIsInVzZXJuYW1lIjoiYXJ0ZW0ubWFydHluZW5rb0Bwcml2YXRiYW5rLnVhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTYzNDkxMTMwMiwiZXhwIjoxNjM0OTE0OTAyfQ.zkypkojTY1i40ecYt7YRLyJIPrme6s329ye-rOiXxWMMCRd2KDzbREmMVSJTf5zfjrj-_8hIShVFvzBUJCPSag")
                .get()
                .url(baseUrl + "/image/profile")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        ResponseBody response = call.execute().body();
        System.out.println(request);
        return response.string();
    }
}
