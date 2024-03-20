package com.webservice.restaurant.Services;

import com.webservice.restaurant.Entities.Dish;
import com.webservice.restaurant.Entities.Restaurant;
import com.webservice.restaurant.Exceptions.ResourceAlreadyExistsException;
import com.webservice.restaurant.Exceptions.RestaurantNotFoundException;
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

    public List<Restaurant> getAllRestaurants(){

        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id){
        return restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){


        if (restaurantRepository.existsByName(restaurant.getName())) {
            throw new ResourceAlreadyExistsException(restaurant.getName());
        }
        // Add any necessary validation logic before saving
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, @RequestBody Restaurant restaurantNew){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));

        restaurant.setName(restaurantNew.getName());
        restaurant.setAddress(restaurantNew.getAddress());
        restaurant.setId(restaurantNew.getId());
        restaurant.setCuisine(restaurantNew.getCuisine());
        restaurant.setDishes(restaurantNew.getDishes());
        return restaurantRepository.save(restaurant);

    }

    public void deleteRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        restaurantRepository.delete(restaurant);
    }

}
