package com.webservice.restaurant.Controllers;

import com.webservice.restaurant.Entities.Dish;
import com.webservice.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/dishes")
    public List<Dish> getAllDishes(){
        return restaurantService.getAllDishes();

    }
    @GetMapping("/dishes/{id}")
    public Dish getDishById(@PathVariable Long id){

        return restaurantService.getDishById(id);
    }

    @PostMapping("/dishes")
    public Dish createDish(@RequestBody Dish dish){

        return restaurantService.createDish(dish);
    }

    @DeleteMapping("/dishes/{id}")
    public void deleteDish(@PathVariable Long id){
        restaurantService.deleteDish(id);
    }

    @GetMapping("/restaurants/{restaurant_id}/dishes")
    public List<Dish> getDishByRestaurant(@PathVariable Long restaurant_id){

        return restaurantService.getDishByRestaurant(restaurant_id);

    }

    @PutMapping("/dishes/{id}")
    public Dish updateDish(@PathVariable Long id, @RequestBody Dish dishDetails) {
        return restaurantService.updateDish(id, dishDetails);
    }
}
