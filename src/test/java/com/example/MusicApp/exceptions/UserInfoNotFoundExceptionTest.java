package com.example.MusicApp.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserInfoNotFoundExceptionTest {

    @Test
    void itShouldTestUserNotFoundException() {
        String message = "UserInfo not associated with this User";
        var expectedException = Assertions.assertThrows(UserInfoNotFoundException.class, () -> {
            throw new UserInfoNotFoundException(message);
        });
        Assertions.assertEquals(message, expectedException.getMessage());
    }

    @Test
    void itShouldTestUserNotFoundException_1() {
        String message = "UserInfo not associated with this User";
        Assertions.assertEquals(message, "UserInfo not associated with this User");
    }
}
