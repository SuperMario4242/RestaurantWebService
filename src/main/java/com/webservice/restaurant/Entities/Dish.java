package com.webservice.restaurant.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webservice.restaurant.Entities.Restaurant;
import jakarta.persistence.*;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public Dish(){

    }


    private int potionSize;

    private String cuisine;

    private Float price;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;


//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPotionSize() {
        return potionSize;
    }

    public void setPotionSize(int potionSize) {
        this.potionSize = potionSize;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
