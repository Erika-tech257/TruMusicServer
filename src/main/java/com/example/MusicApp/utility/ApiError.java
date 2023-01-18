package com.example.MusicApp.utility;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private HttpStatus httpStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    private LocalDateTime dateTime;

    private String message;

    private String debugMessage;

    private List<ApiSubError> subErrors;

    private ApiError(){
        dateTime = LocalDateTime.now();
    }

    ApiError(HttpStatus httpStatus){
        this();
        this.httpStatus =  httpStatus;
    }

    ApiError(HttpStatus httpStatus, Throwable ex) {
        this();
        this.httpStatus = httpStatus;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError(HttpStatus httpStatus, String message, Throwable ex) {
        this();
        this.httpStatus = httpStatus;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

}
