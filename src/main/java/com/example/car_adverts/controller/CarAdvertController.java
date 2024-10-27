package com.example.car_adverts.controller;

import com.example.car_adverts.model.CarAdvert;
import com.example.car_adverts.service.CarAdvertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car/adverts")
public class CarAdvertController {

    private final CarAdvertService carAdvertService;

    public CarAdvertController(CarAdvertService carAdvertService) {
        this.carAdvertService = carAdvertService;
    }

    @GetMapping
    public List<CarAdvert> getAllCarAdverts(@RequestParam(value = "sort", defaultValue = "id") String sortBy) {
        return carAdvertService.getAllCarAdverts(sortBy);
    }

    @PostMapping
    public ResponseEntity<?> createCarAdvert(@RequestBody CarAdvert carAdvert) {
        if (carAdvert.getPrice() < 0 || carAdvert.getId() <= 0) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(Map.of("validation_errors", List.of(
                            carAdvert.getId() <= 0 ? "Id must be a positive number" : "",
                            carAdvert.getPrice() < 0 ? "Price cannot be negative" : ""
                    )));
        }

        try {
            CarAdvert createdAdvert = carAdvertService.createCarAdvert(carAdvert);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAdvert);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", e.getMessage()));
        }
    }
}