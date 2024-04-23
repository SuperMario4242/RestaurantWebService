package com.webservice.restaurant;

import com.webservice.restaurant.Entities.Dish;
import com.webservice.restaurant.Entities.Restaurant;
import com.webservice.restaurant.Services.DishService;
import com.webservice.restaurant.Services.RestaurantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SampleDataLoader implements CommandLineRunner {

    private final RestaurantService restaurantService;
    private final DishService dishService;


    public SampleDataLoader(RestaurantService restaurantService, DishService dishService) {
        this.restaurantService = restaurantService;

        this.dishService = dishService;
    }

    @Override
    public void run(String... args){
        Restaurant restaurantA = getRestaurant("RestaurantA","Lithuanian","Pylimo");
        Restaurant restaurantB = getRestaurant("MC Donalds","German","Address2435");
        Restaurant restaurantC = getRestaurant("KFC","Polish","Address365257");
        restaurantService.createRestaurant(restaurantA);
        restaurantService.createRestaurant(restaurantB);
        restaurantService.createRestaurant(restaurantC);

        Dish dish1= getDish("Dish 111",10.99f,restaurantA);
        Dish dish2 = getDish("Dish 222",15.99f,restaurantB);
        Dish dish3 = getDish("Dish 333",5,restaurantC);
        Dish dish4= getDish("Dish444",1.0f,restaurantA);
        Dish dish5 = getDish("Dish555",2.35f,restaurantB);
        Dish dish6 = getDish("Dish666",7.0f,restaurantC);

        dishService.createDish(dish1);
        dishService.createDish(dish2);
        dishService.createDish(dish3);
        dishService.createDish(dish4);
        dishService.createDish(dish5);
        dishService.createDish(dish6);}

    private static Restaurant getRestaurant(String name, String cuisine, String address ) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setCuisine(cuisine);
        restaurant.setAddress(address);
        return restaurant;
    }
    private static Dish getDish(String title, float price, Restaurant restaurant ) {
        Dish dish = new Dish();
        dish.setTitle(title);
        dish.setPrice(price);
        dish.setRestaurant(restaurant);
        return dish;
    }
}