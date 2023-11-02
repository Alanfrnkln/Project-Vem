package com.example.projetovem.controllers.exceptions;

import com.example.projetovem.services.exceptions.CardNotFoundException;
import com.example.projetovem.services.exceptions.DatabaseException;
import com.example.projetovem.services.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> userNotFound(UserNotFoundException e, HttpServletRequest request){
        String error = "Usuario não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseError(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<StandardError> userNotFound(CardNotFoundException e, HttpServletRequest request){
        String error = "Cartão não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

}
