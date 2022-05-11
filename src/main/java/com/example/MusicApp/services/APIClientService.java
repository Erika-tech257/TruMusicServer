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
         log.info("Exception for OKHttpClient in APICLientService");
         e.printStackTrace();  //set up logger or aop logging instead of stacktrace
      }
         return null;
   }
//OkHttpClient client = new OkHttpClient();
//
//   Request request = new Request.Builder()
//           .url("https://deezerdevs-deezer.p.rapidapi.com/artist/1")
//           .get()
//           .addHeader("X-RapidAPI-Host", "deezerdevs-deezer.p.rapidapi.com")
//           .addHeader("X-RapidAPI-Key", "7e5a0303c8mshef9b3740265dcdcp13d713jsn012f72621fcc")
//           .build();
//
//   Response response;
//
//   {
//      try {
//         response = client.newCall(request).execute();
//         System.out.println(response);
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
//   }

}
