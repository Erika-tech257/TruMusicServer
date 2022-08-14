package com.example.MusicApp.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

@ExtendWith(MockitoExtension.class)
public class ApiExceptionTest {

     private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
     private final ZonedDateTime timestamp = ZonedDateTime.parse("2007-12-03T10:15:30+01:00");


    @Test
    void itShouldValidateApiException() {
        String message = "ApiException Thrown";
        ApiException apiException = new ApiException(message, httpStatus, timestamp);
        Assertions.assertNotNull(apiException);
        Assertions.assertEquals(httpStatus, HttpStatus.BAD_REQUEST);
        Assertions.assertEquals(timestamp, ZonedDateTime.parse("2007-12-03T10:15:30+01:00"));
    }


    @Test
    void getMessage() {
        String message = " ";
        var expectedException = Assertions.assertThrows(ApiException.class, () -> {
            throw new ApiException(message, httpStatus, timestamp);
        });
        Assertions.assertEquals(message, expectedException.getMessage());
    }

    @Test
    void getHttpStatus() {
        String message = "Api Error";
        var expectedException = Assertions.assertThrows(ApiException.class, () -> {
            throw new ApiException(message, httpStatus, timestamp);
        });
        Assertions.assertEquals(httpStatus, expectedException.getHttpStatus());
    }

    @Test
    void getTimestamp() {
        String message = "Api Error";

        var expectedException = Assertions.assertThrows(ApiException.class, () -> {
            throw new ApiException(message, httpStatus, timestamp);
        });
        Assertions.assertEquals(timestamp, expectedException.getTimestamp());
    }
}

