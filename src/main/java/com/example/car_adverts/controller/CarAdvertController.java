package com.example.car_adverts.controller;

import com.example.car_adverts.model.CarAdvert;
import com.example.car_adverts.service.CarAdvertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarAdvertController {
    private final CarAdvertService carAdvertService;

    public CarAdvertController(CarAdvertService carAdvertService) {
        this.carAdvertService = carAdvertService;
    }

    @GetMapping("/car/adverts")
    public List<CarAdvert> getAllCarAdverts(@RequestParam(value = "sort", defaultValue = "id") String sortBy) {
        return carAdvertService.getAllCarAdverts(sortBy);
    }
}
