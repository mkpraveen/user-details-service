package org.praveenmk.microservice.learn.userdetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserServiceExceptionHandler {

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ErrorResponse> handleUserServiceException(Exception ex) {

        ErrorResponse errResponse = new ErrorResponse();
        errResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errResponse.setErrorMessage(ex.getMessage());

        return new ResponseEntity(errResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {

        ErrorResponse errResponse = new ErrorResponse();
        errResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errResponse.setErrorMessage(ex.getMessage());

        return new ResponseEntity(errResponse, HttpStatus.BAD_REQUEST);
    }
}
