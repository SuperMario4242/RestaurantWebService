package com.webservice.restaurant.Repositories;

import com.webservice.restaurant.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    boolean existsByName(String name);
}
