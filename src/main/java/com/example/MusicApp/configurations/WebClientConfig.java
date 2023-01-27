package com.example.MusicApp.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {

//    @Bean
//       public WebClient.Builder getWebClient(){
//        return WebClient.builder();
//    }

    @Bean
    public WebClient createWebClient() {
        return WebClient.builder()
                .baseUrl("https://deezerdevs-deezer.p.rapidapi.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
