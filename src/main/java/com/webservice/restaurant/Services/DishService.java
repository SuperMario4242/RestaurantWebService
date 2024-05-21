package com.webservice.restaurant.Services;

import com.webservice.restaurant.Entities.Dish;
import com.webservice.restaurant.Exceptions.*;
import com.webservice.restaurant.Repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishes(){
        return dishRepository.findAll();

    }
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish){
        if (dish.getId()!=null && dishRepository.existsById(dish.getId())) {
            throw new DishAlreadyExistsException(dish.getId());
        }
        if (dish.getId()!=null && !dishRepository.existsById(dish.getId())) {
            throw new InvalidRequestException("Do not write id manually it is generated automatically");
        }
        Dish savedDish = dishRepository.save(dish);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedDish);
    }
    public void deleteDish(@PathVariable Long id){

        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new DishNotFoundException(id));
        dishRepository.deleteById(id);

    }
    public List<Dish> getDishByRestaurant(@PathVariable Long restaurant_id){

        List<Dish> dishes = dishRepository.findByRestaurantId(restaurant_id);
        if (dishes.isEmpty()) {
            throw new NoDishesFoundForRestaurantException(restaurant_id);
        }
        return dishes;
    }
    public Dish getDishById(@PathVariable Long id){
        return dishRepository.findById(id).orElseThrow(() -> new DishNotFoundException(id));
    }

    public Dish updateDish(@PathVariable Long id, Dish dishNew){
        if(dishNew.getId() !=null && !Objects.equals(dishNew.getId(), id)){
            throw new InvalidRequestException("We can not change id");
        }
        return dishRepository.findById(id).map(dish -> {
            dish.setTitle(dishNew.getTitle());
            dish.setPrice(dishNew.getPrice());
            dish.setRestaurant(dishNew.getRestaurant());
            return dishRepository.save(dish);
        }).orElseThrow(() -> new DishNotFoundException(id));
    }
}
