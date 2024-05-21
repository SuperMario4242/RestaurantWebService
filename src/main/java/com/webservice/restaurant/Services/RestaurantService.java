package com.webservice.restaurant.Services;

import com.webservice.restaurant.Entities.Restaurant;
import com.webservice.restaurant.Exceptions.InvalidRequestException;
import com.webservice.restaurant.Exceptions.RestaurantAlreadyExistsException;
import com.webservice.restaurant.Exceptions.RestaurantNotFoundException;
import com.webservice.restaurant.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants(){

        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(@PathVariable Long id){
        return restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){
        if (restaurant.getId() != null && restaurantRepository.existsById(restaurant.getId())) {
            throw new RestaurantAlreadyExistsException(restaurant.getId());
        }
        if (restaurant.getId() != null && !restaurantRepository.existsById(restaurant.getId())) {
            throw new InvalidRequestException("Do not write id manually it is generated automatically");
        }
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRestaurant);
    }

    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantNew){
        if(restaurantNew.getId() !=null && !Objects.equals(restaurantNew.getId(), id)){
            throw new InvalidRequestException("We can not change id");

        }
        return restaurantRepository.findById(id).map(restaurant -> {
            restaurant.setName(restaurantNew.getName());
            restaurant.setAddress(restaurantNew.getAddress());
            restaurant.setCuisine(restaurantNew.getCuisine());
            restaurant.setDishes(restaurantNew.getDishes());
            return restaurantRepository.save(restaurant);
        }).orElseThrow(() -> new RestaurantNotFoundException(id));


        //Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
        restaurantRepository.delete(restaurant);
    }

}
