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
    public void run(String... args) throws Exception {

        //List<Dish> dishList = new ArrayList<Dish>();


        // Pridedame pavyzdinius restoranus
        Restaurant restaurantA = new Restaurant();
        restaurantA.setName("Restaurant A");
        restaurantA.setCuisine("Italian");
        restaurantA.setAddress("Gedimino Pr.");
        //restaurantA.setDishes();
        restaurantService.createRestaurant(restaurantA);

        Restaurant restaurantB = new Restaurant();
        restaurantB.setName("Restaurant B");
        restaurantService.createRestaurant(restaurantB);

        Restaurant restaurantC = new Restaurant();
        restaurantC.setName("Restaurant C");
        restaurantService.createRestaurant(restaurantC);

        // Pridedame pavyzdinius patiekalus
        Dish dish1 = new Dish();
        dish1.setTitle("Dish 1");
        dish1.setPrice(10.99f);
        //dish1.setRestaurant(restaurantA);
        dishService.createDish(dish1);

        Dish dish2 = new Dish();
        dish2.setTitle("Dish 2");
        dish2.setPrice(15.99f);
        //dish2.setRestaurant(restaurantA);
        dishService.createDish(dish2);

        Dish dish3 = new Dish();
        dish3.setTitle("Dish 3");
        dish3.setPrice(8.99f);
        //dish3.setRestaurant(restaurantB);
        dishService.createDish(dish3);

        Dish dish4 = new Dish();
        dish4.setTitle("Dish 4");
        dish4.setPrice(12.50f);
        //dish4.setRestaurant(restaurantC);
        dishService.createDish(dish4);

        Dish dish5 = new Dish();
        dish5.setTitle("Dish 5");
        dish5.setPrice(9.75f);
        //dish5.setRestaurant(restaurantC);
        dishService.createDish(dish5);
    }
}