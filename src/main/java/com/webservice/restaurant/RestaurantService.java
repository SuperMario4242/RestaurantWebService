package com.webservice.restaurant;

import com.webservice.restaurant.Entities.Dish;
import com.webservice.restaurant.Entities.Restaurant;
import com.webservice.restaurant.Repositories.DishRepository;
import com.webservice.restaurant.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private DishRepository dishRepository;


    public List<Restaurant> getAllRestaurants(){

        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id){
        return restaurantRepository.findById(id).orElse(null);
    }

    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, @RequestBody Restaurant restaurantNew){
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        if(restaurant == null){
            return null;
        }
        restaurant.setName(restaurantNew.getName());
        restaurant.setAddress(restaurantNew.getAddress());
        restaurant.setId(restaurantNew.getId());
        restaurant.setCuisine(restaurantNew.getCuisine());
        restaurant.setDishes(restaurantNew.getDishes());
        return restaurantRepository.save(restaurant);

    }

    public void deleteRestaurant(@PathVariable Long id) {
        restaurantRepository.deleteById(id);
    }


    public List<Dish> getAllDishes(){
        return dishRepository.findAll();

    }

    public Dish createDish(@RequestBody Dish dish){

        return dishRepository.save(dish);
    }


    public void deleteDish(@PathVariable Long id){
        dishRepository.deleteById(id);
    }

    public List<Dish> getDishByRestaurant(@PathVariable Long restaurant_id){

        return dishRepository.findByRestaurantId(restaurant_id);

    }

    public Dish getDishById(Long id){
        return dishRepository.findById(id).orElse(null);
    }


    public Dish updateDish(Long id, Dish dishNew){

        Dish dish = dishRepository.findById(id).orElse(null);

        if(dish == null) return null;

        dish.setTitle(dishNew.getTitle());
        dish.setId(dishNew.getId());
        dish.setPrice(dish.getPrice());
        dish.setPotionSize(dishNew.getPotionSize());
        dish.setCuisine(dishNew.getCuisine());
        dish.setRestaurant(dish.getRestaurant());

        return dishRepository.save(dish);
    }

}
