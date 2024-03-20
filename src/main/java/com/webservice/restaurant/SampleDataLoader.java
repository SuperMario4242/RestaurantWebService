package com.webservice.restaurant;

import com.webservice.restaurant.Entities.Dish;
import com.webservice.restaurant.Entities.Restaurant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SampleDataLoader implements CommandLineRunner {


    private final RestaurantService restaurantService;


    public SampleDataLoader(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;

    }

    @Override
    public void run(String... args) throws Exception {

        List<Dish> dishList = new ArrayList<>();
        Restaurant restaurantA = new Restaurant();
        Restaurant restaurantB = new Restaurant();
        Restaurant restaurantC = new Restaurant();

        // Pridedame pavyzdinius patiekalus
        Dish dish1 = new Dish();
        dish1.setTitle("Dish 1");
        dish1.setPrice(10.99f);
        dish1.setCuisine("Italian");
        dish1.setPotionSize(2);
        dish1.setRestaurant(restaurantA);
        restaurantService.createDish(dish1);

        Dish dish2 = new Dish();


        dish2.setCuisine("Italian");
        dish2.setPotionSize(2);
        dish2.setTitle("Dish 2");
        dish2.setPrice(15.99f);
        dish2.setRestaurant(restaurantA);
        restaurantService.createDish(dish2);

        Dish dish3 = new Dish();
        dish3.setCuisine("German");
        dish3.setPotionSize(2);
        dish3.setTitle("Dish 3");
        dish3.setPrice(8.99f);
        dish3.setRestaurant(restaurantB);
        restaurantService.createDish(dish3);

        Dish dish4 = new Dish();

        dish4.setCuisine("Polish");
        dish4.setPotionSize(1);

        dish4.setTitle("Dish 4");
        dish4.setPrice(12.50f);
        dish4.setRestaurant(restaurantC);
        restaurantService.createDish(dish4);

        Dish dish5 = new Dish();
        dish1.setCuisine("Polish");
        dish1.setPotionSize(2);
        dish5.setTitle("Dish 5");
        dish5.setPrice(9.75f);
        dish5.setRestaurant(restaurantC);
        restaurantService.createDish(dish5);
        // Pridedame pavyzdinius restoranus

        dishList.add(dish1);
        dishList.add(dish2);
        dishList.add(dish3);
        dishList.add(dish4);


        restaurantA.setName("Restaurant A");
        restaurantA.setAddress("Gedimino Pr.");
        restaurantA.setCuisine("Italian");
        restaurantA.setDishes(dishList);
        restaurantService.createRestaurant(restaurantA);


        restaurantB.setName("Restaurant B");
        restaurantB.setAddress("Vokieciu gatve.");
        restaurantB.setCuisine("German");
        restaurantB.setDishes(dishList);
        restaurantService.createRestaurant(restaurantB);


        restaurantC.setName("Restaurant C");
        restaurantC.setAddress("Kalvarijos gatve.");
        restaurantC.setCuisine("Polish");
        restaurantC.setDishes(dishList);
        restaurantService.createRestaurant(restaurantC);


    }
}
