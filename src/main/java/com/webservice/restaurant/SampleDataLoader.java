package com.webservice.restaurant;

import com.webservice.restaurant.Entities.Dish;
import com.webservice.restaurant.Entities.Restaurant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class SampleDataLoader implements CommandLineRunner {


    private final RestaurantService restaurantService;


    public SampleDataLoader(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;

    }

    @Override
    public void run(String... args) throws Exception {
        // Pridedame pavyzdinius restoranus
        Restaurant restaurantA = new Restaurant();
        restaurantA.setName("Restaurant A");
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
        dish1.setRestaurant(restaurantA);
        restaurantService.createDish(dish1);

        Dish dish2 = new Dish();
        dish2.setTitle("Dish 2");
        dish2.setPrice(15.99f);
        dish2.setRestaurant(restaurantA);
        restaurantService.createDish(dish2);

        Dish dish3 = new Dish();
        dish3.setTitle("Dish 3");
        dish3.setPrice(8.99f);
        dish3.setRestaurant(restaurantB);
        restaurantService.createDish(dish3);

        Dish dish4 = new Dish();
        dish4.setTitle("Dish 4");
        dish4.setPrice(12.50f);
        dish4.setRestaurant(restaurantC);
        restaurantService.createDish(dish4);

        Dish dish5 = new Dish();
        dish5.setTitle("Dish 5");
        dish5.setPrice(9.75f);
        dish5.setRestaurant(restaurantC);
        restaurantService.createDish(dish5);
    }
}
