package org.projectrepo;

import io.github.cdimascio.dotenv.Dotenv;
import jdk.javadoc.doclet.DocletEnvironment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;

public class Client {
    private static final String API_KEY = Dotenv.load().get("WEATHERAPP_API_KEY");
    private static final String BASE_URL = Dotenv.load().get("WEATHERAPP_API_URL");
    private final OkHttpClient client;

    public Client() {
        this.client = new OkHttpClient();
    }

    public String getWeather(String city) throws Exception {
        String url = BASE_URL + "?q=" + city + "&appid=" + API_KEY;
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
