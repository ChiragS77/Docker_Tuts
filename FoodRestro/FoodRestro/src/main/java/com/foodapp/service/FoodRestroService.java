package com.foodapp.service;

import com.foodapp.entity.FoodRestro;
import com.foodapp.repository.FoodRestroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodRestroService
{

    private final FoodRestroRepository repository;

    // POST - Save a new restaurant
    public FoodRestro saveRestaurant(FoodRestro restaurant) {
        return repository.save(restaurant);
    }

    // GET ALL - Fetch all restaurants
    public List<FoodRestro> getAllRestaurants() {
        return repository.findAll();
    }

    // GET BY ID - Fetch a single restaurant
    public Optional<FoodRestro> getRestaurantById(Long id) {
        return repository.findById(id);
    }

    // DELETE - Remove a restaurant by its ID
    public boolean deleteRestaurant(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


}
