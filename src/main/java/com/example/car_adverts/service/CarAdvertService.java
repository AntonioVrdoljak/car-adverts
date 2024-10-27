package com.example.car_adverts.service;

import com.example.car_adverts.model.CarAdvert;
import com.example.car_adverts.repository.CarAdvertRepository;
import org.springframework.stereotype.Service;

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

        Comparator<CarAdvert> comparator = switch (sortBy.toLowerCase()) {
            case "price" -> Comparator.comparingInt(CarAdvert::getPrice);
            case "title" -> Comparator.comparing(CarAdvert::getTitle);
            case "fueltype" -> Comparator.comparing(CarAdvert::getFuelType);
            case "mileage" -> Comparator.comparingInt(CarAdvert::getMileage);
            default -> Comparator.comparingInt(CarAdvert::getId);
        };

        adverts.sort(comparator);
        return adverts;
    }

    public CarAdvert createCarAdvert(CarAdvert carAdvert) {
        if (carAdvertRepository.existsById(carAdvert.getId())) {
            throw new IllegalArgumentException("Advert with the same ID already exists.");
        }
        return carAdvertRepository.save(carAdvert);
    }
}