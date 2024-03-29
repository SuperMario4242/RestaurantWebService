package com.webservice.restaurant.Repositories;

import com.webservice.restaurant.Entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository  extends JpaRepository<Dish, Long> {

    List<Dish> findByRestaurantId(Long restaurantId);

    boolean existsByTitle(String title);
}
