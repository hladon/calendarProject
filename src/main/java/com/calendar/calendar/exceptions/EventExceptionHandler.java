package com.calendar.calendar.exceptions;

import com.calendar.calendar.controller.MainController;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes ={MainController.class} )
public class EventExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> allExceptions(Exception e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DaoException.class)
    public ResponseEntity<String> daoExceptions(DaoException e) {
        return new ResponseEntity<String>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<String> daoExceptions(TypeMismatchException e) {
        return new ResponseEntity<String>("Wrong input", HttpStatus.BAD_REQUEST);
    }
}
