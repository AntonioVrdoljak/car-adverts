package com.example.car_adverts.model;

import java.time.LocalDate;

public class CarAdvert {

    private int id;
    private String title;
    private String fuelType;
    private int price;
    private boolean isNew;
    private Integer mileage;
    private LocalDate firstRegistration;

    public CarAdvert() {}

    public CarAdvert(int id, String title, String fuelType, int price, boolean isNew, Integer mileage, LocalDate firstRegistration) {
        this.id = id;
        this.title = title;
        this.fuelType = fuelType;
        this.price = price;
        this.isNew = isNew;
        this.mileage = mileage;
        this.firstRegistration = firstRegistration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public LocalDate getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(LocalDate firstRegistration) {
        this.firstRegistration = firstRegistration;
    }
}