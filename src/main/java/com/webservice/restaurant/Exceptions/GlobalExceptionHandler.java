package com.webservice.restaurant.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRestaurantNotFoundException(RestaurantNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse() {
            @Override
            public HttpStatusCode getStatusCode() {
                return null;
            }

            @Override
            public ProblemDetail getBody() {
                return null;
            }
        };
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleRestaurantAlreadyExistsException(ResourceAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse() {
            @Override
            public HttpStatusCode getStatusCode() {
                return null;
            }

            @Override
            public ProblemDetail getBody() {
                return null;
            }
        };
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestException(InvalidRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse() {
            @Override
            public HttpStatusCode getStatusCode() {
                return null;
            }

            @Override
            public ProblemDetail getBody() {
                return null;
            }
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(NoDishesFoundForRestaurantException.class)
    public ResponseEntity<ErrorResponse> handleNoDishesFoundForRestaurantException(NoDishesFoundForRestaurantException ex) {
        ErrorResponse errorResponse = new ErrorResponse() {
            @Override
            public HttpStatusCode getStatusCode() {
                return null;
            }

            @Override
            public ProblemDetail getBody() {
                return null;
            }
        };
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}