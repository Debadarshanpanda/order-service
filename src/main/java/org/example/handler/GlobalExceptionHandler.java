package org.example.handler;

import org.example.exception.ApiError;
import org.example.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception){
        ApiError error = ApiError.builder()
                .errorMessage(exception.getMessage())
                .description("user not found")
                .status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
