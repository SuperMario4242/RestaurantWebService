package com.webservice.restaurant.Controllers;

import com.webservice.restaurant.Entities.Restaurant;
import com.webservice.restaurant.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants(){

        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getRestaurantByID(@PathVariable Long id){

        return restaurantService.getRestaurantById(id);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.createRestaurant(restaurant);
    }

    @PutMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant authorDetails) {
        return restaurantService.updateRestaurant(id, authorDetails);
    }


    @DeleteMapping("/restaurants/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }



}
