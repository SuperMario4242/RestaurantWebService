package com.webservice.restaurant.Controllers;

import com.webservice.restaurant.Entities.Dish;
import com.webservice.restaurant.Services.DishService;
import com.webservice.restaurant.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/dishes")
    public List<Dish> getAllDishes(){
        return dishService.getAllDishes();

    }
    @GetMapping("/dishes/{id}")
    public Dish getDishById(@PathVariable Long id){

        return dishService.getDishById(id);
    }

    @PostMapping("/dishes")
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish){

        return dishService.createDish(dish);
    }

    @DeleteMapping("/dishes/{id}")
    public void deleteDish(@PathVariable Long id){
        dishService.deleteDish(id);
    }

    @GetMapping("/restaurants/{restaurant_id}/dishes")
    public List<Dish> getDishByRestaurant(@PathVariable Long restaurant_id){

        return dishService.getDishByRestaurant(restaurant_id);

    }

    @PutMapping("/dishes/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody Dish dishDetails) {
        return dishService.updateDish(id, dishDetails);
    }
}
