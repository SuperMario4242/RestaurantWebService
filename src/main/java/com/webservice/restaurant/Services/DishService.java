package com.webservice.restaurant.Services;

import com.webservice.restaurant.Entities.Dish;
import com.webservice.restaurant.Exceptions.NoDishesFoundForRestaurantException;
import com.webservice.restaurant.Exceptions.ResourceAlreadyExistsException;
import com.webservice.restaurant.Exceptions.RestaurantNotFoundException;
import com.webservice.restaurant.Repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;


    public List<Dish> getAllDishes(){
        return dishRepository.findAll();

    }

    public ResponseEntity<Dish> createDish(@RequestBody Dish dish){



        if (dishRepository.existsByTitle(dish.getTitle())) {
            throw new ResourceAlreadyExistsException(dish.getTitle());
        }
        Dish savedDish = dishRepository.save(dish);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedDish);
    }


    public void deleteDish(@PathVariable Long id){

        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
        dishRepository.deleteById(id);
    }

    public List<Dish> getDishByRestaurant(@PathVariable Long restaurant_id){

        List<Dish> dishes = dishRepository.findByRestaurantId(restaurant_id);
        if (dishes.isEmpty()) {
            throw new NoDishesFoundForRestaurantException(restaurant_id);
        }
        return dishes;

    }

    public Dish getDishById(Long id){
        return dishRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));
    }


    public ResponseEntity<Dish> updateDish(Long id, Dish dishNew){

        Dish dish = dishRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));

        dish.setTitle(dishNew.getTitle());
        dish.setId(dishNew.getId());
        dish.setPrice(dish.getPrice());
        dish.setRestaurant(dish.getRestaurant());

        Dish updatedDish = dishRepository.save(dish);

        return  ResponseEntity.ok(updatedDish);
    }

}
