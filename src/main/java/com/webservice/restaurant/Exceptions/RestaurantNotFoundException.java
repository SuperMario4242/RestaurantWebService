package com.webservice.restaurant.Exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(Long restaurantId) {
        super("Restaurant not found with ID: " + restaurantId);
    }
}
