package com.weatherapp.controller;

import com.weatherapp.entity.Weather;
import com.weatherapp.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherRepository weatherRepository;



    @GetMapping("/name")
    public String weatherName(){
        return "Clouds are dark and Weather is Windy...chirag , saloni";
    }

    @PostMapping("/build")
    public ResponseEntity<?>  buildWeatherData(@RequestBody Weather weather){


             this.weatherRepository.save(weather);

             return  ResponseEntity.ok("Weather data has been saved");
    }

    @GetMapping("/weather-report")
    public  ResponseEntity<?> getWeatherData(){
        return ResponseEntity.ok(this.weatherRepository.findAll());
    }


}
