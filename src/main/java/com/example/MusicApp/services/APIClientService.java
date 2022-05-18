package com.example.MusicApp.services;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.util.Objects;

@Slf4j
public class APIClientService {
   private static final OkHttpClient apiClient = new OkHttpClient();

   public static String get(String url) {
      Request req = new Request.Builder().url(url).build();
      try (Response response = apiClient.newCall(req).execute()) {
         return Objects.requireNonNull(response.body()).string();
      } catch (IOException e) {
         log.info("Exception for OKHttpClient in APIClientService");
         e.printStackTrace();  //set up logger or aop logging instead of stacktrace
      }
         return null;
   }

}
