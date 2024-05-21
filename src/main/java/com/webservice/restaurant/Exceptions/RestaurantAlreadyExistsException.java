package com.webservice.restaurant.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RestaurantAlreadyExistsException extends RuntimeException {

    public RestaurantAlreadyExistsException(Long message) {
        super("Restaurant with  ID "+ message + " already exists");
    }
}
