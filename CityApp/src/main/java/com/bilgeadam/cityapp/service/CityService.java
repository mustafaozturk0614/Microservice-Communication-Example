package com.bilgeadam.cityapp.service;

import com.bilgeadam.cityapp.entities.City;

import java.util.List;

public interface CityService {

    City createCity(City city);
    City updateCity(City city);
    List<City> getAllCities();
    City findCityById(Long id);
    void deleteCity(Long id);
}
