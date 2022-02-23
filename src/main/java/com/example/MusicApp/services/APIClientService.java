package com.example.MusicApp.services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class APIClientService {
   private static final OkHttpClient apiClient = new OkHttpClient();

   public static String get(String url) {
      Request req = new Request.Builder().url(url).build();
      try (Response response = apiClient.newCall(req).execute()) {
         return Objects.requireNonNull(response.body()).string();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return null;
   }


}
