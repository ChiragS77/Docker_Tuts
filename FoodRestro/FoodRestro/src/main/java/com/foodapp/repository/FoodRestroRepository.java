package com.foodapp.repository;

import com.foodapp.entity.FoodRestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRestroRepository extends JpaRepository<FoodRestro,Long> {
}
