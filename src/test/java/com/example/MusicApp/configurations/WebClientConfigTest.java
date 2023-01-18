//package com.example.MusicApp.configurations;
//
//import com.example.MusicApp.controllers.PlaylistController;
//import com.example.MusicApp.models.PlayList;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest()
//@ExtendWith(SpringExtension.class)
//class WebClientConfigTest {
//
//
//    @Mock
//    private WebClient webClientMock;
//
//    @Mock
//    private WebClient.RequestBodyUriSpec requestBodyUriSpecMock;
//
//    @Mock
//    private WebClient.RequestBodySpec requestBodySpecMock;
//
//    @SuppressWarnings("rawtypes")
//    @Mock
//    private WebClient.RequestHeadersSpec requestHeadersSpecMock;
//
//    @SuppressWarnings("rawtypes")
//    @Mock
//    private WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;
//
//    @Mock
//    private WebClient.ResponseSpec responseSpecMock;
//
//    @Mock
//    private Mono<PlayList> postResponseMock;
//
//    @InjectMocks
//    private PlaylistController controllerMock;
//
//
//    @SuppressWarnings("unchecked")
//    @Test
//    public void test_createPost() throws Exception {
//
//        PlayList playList = new PlayList(1002, "Levels", "Some title");
//
//        when(webClientMock.post()).thenReturn(requestBodyUriSpecMock);
//        when(requestBodyUriSpecMock.uri(Mockito.anyString())).thenReturn(requestBodySpecMock);
//        when(requestBodySpecMock.header(Mockito.any(), Mockito.any())).thenReturn(requestBodySpecMock);
//        when(requestBodySpecMock.body(Mockito.any())).thenReturn(requestHeadersSpecMock);
//        when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);
//        when(responseSpecMock.bodyToMono(
//                ArgumentMatchers.<Class<PlayList>>notNull())).thenReturn(Mono.just(playList));
//
//        Mono<PlayList> response = controllerMock.createPost(playList);
//        Assertions.assertEquals(1002, response.block().getId());
//        Assertions.assertEquals("Levels", response.block().getTitle());
//    }
//}