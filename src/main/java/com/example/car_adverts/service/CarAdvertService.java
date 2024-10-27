package com.example.car_adverts.service;

import com.example.car_adverts.model.CarAdvert;
import com.example.car_adverts.repository.CarAdvertRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CarAdvertService {

    private final CarAdvertRepository carAdvertRepository;

    public CarAdvertService(CarAdvertRepository carAdvertRepository) {
        this.carAdvertRepository = carAdvertRepository;
    }

    public List<CarAdvert> getAllCarAdverts(String sortBy) {
        List<CarAdvert> adverts = carAdvertRepository.findAll();

        Comparator<CarAdvert> comparator;
        switch (sortBy.toLowerCase()) {
            case "price":
                comparator = Comparator.comparingInt(CarAdvert::getPrice);
                break;
            case "title":
                comparator = Comparator.comparing(CarAdvert::getTitle);
                break;
            case "fueltype":
                comparator = Comparator.comparing(CarAdvert::getFuelType);
                break;
            case "mileage":
                comparator = Comparator.comparingInt(CarAdvert::getMileage);
                break;
            default:
                comparator = Comparator.comparingInt(CarAdvert::getId);
        }

        adverts.sort(comparator);
        return adverts;
    }
}