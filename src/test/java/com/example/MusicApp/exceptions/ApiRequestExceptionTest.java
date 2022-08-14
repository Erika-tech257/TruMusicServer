package com.example.MusicApp.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ApiRequestExceptionTest {

    @Test
    void assertApiRequestException() {
        var message = "Cannot get all users with custom exception";
        var expectedException = Assertions.assertThrows(
                ApiRequestException.class, () -> {
                    throw new ApiRequestException(message);
                });
        Assertions.assertEquals(message, expectedException.getMessage());
    }


    @Test
    void itShouldValidateApiRequestException() throws Exception{
        var message = "Cannot get all users with custom exception";
        Throwable cause = new Exception("Exception");
        var expectedException = Assertions.assertThrows(
                ApiRequestException.class, () -> {
                    throw new ApiRequestException(message, cause);
                });
        Assertions.assertEquals(message, expectedException.getMessage());
        Assertions.assertEquals(cause, expectedException.getCause());
    }

}