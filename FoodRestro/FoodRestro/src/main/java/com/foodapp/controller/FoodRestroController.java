package com.foodapp.controller;

import com.foodapp.entity.FoodRestro;
import com.foodapp.service.FoodRestroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restro")
public class FoodRestroController {


    private final FoodRestroService service;

    @PostMapping
    public ResponseEntity<FoodRestro> createRestaurant(@RequestBody FoodRestro restaurant) {
        FoodRestro savedRestaurant = service.saveRestaurant(restaurant);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    // 2. GET ALL API - Retrieve all restaurants
    @GetMapping
    public ResponseEntity<List<FoodRestro>> getAllRestaurants() {
        List<FoodRestro> restaurants = service.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    // 3. GET BY ID API - Retrieve one restaurant
    @GetMapping("/{id}")
    public ResponseEntity<FoodRestro> getRestaurantById(@PathVariable Long id) {
        return service.getRestaurantById(id)
                .map(restaurant -> new ResponseEntity<>(restaurant, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 4. DELETE API - Remove a restaurant
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        boolean isDeleted = service.deleteRestaurant(id);
        if (isDeleted) {
            return new ResponseEntity<>("Restaurant deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Restaurant not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name")
    public String getRestroName(){
        return "The serpent of Yogi in the mountain";
    }

}
