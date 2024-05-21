package com.webservice.restaurant.Exceptions;

public class DishNotFoundException extends  RuntimeException{

    public DishNotFoundException(Long id){
        super("Dish not found with ID: " + id);
    }
}
