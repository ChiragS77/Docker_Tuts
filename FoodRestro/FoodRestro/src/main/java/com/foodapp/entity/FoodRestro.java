package com.foodapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodRestro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cuisineType; // e.g., Italian, Indian, Fast Food

    private String address;

    private String phoneNumber;

    private Double rating; // e.g., 4.5

    private boolean isOpen;

    private String openingHours; // e.g., "09:00 AM - 10:00 PM"
}
