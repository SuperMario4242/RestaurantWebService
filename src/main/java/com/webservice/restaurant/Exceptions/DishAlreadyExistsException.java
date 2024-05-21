package com.webservice.restaurant.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DishAlreadyExistsException extends  RuntimeException {

    public DishAlreadyExistsException(Long  message){
        super("Dish with ID  "+ message + " already exists");

    }
}
