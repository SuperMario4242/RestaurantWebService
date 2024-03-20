package com.webservice.restaurant.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDishesFoundForRestaurantException extends RuntimeException {
    public NoDishesFoundForRestaurantException(Long restaurantId) {
        super("No dishes found for restaurant with ID: " + restaurantId);
    }
}
