package com.bilgeadam.cityapp.service;

import com.bilgeadam.cityapp.entities.City;
import com.bilgeadam.cityapp.exception.ResourceNotFoundException;
import com.bilgeadam.cityapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements  CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(City city) {
        Optional<City> citydB=cityRepository.findById(city.getId());

        if (citydB.isPresent()){
            City cityUpdate=citydB.get();
            cityUpdate.setId(city.getId());
            cityUpdate.setName(city.getName());
           return cityRepository.save(cityUpdate);
        }else {

           throw new ResourceNotFoundException("Record not found with id: "+ city.getId());
        }


    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City findCityById(Long id) {

        Optional<City> city=cityRepository.findById(id);

        if (city.isPresent()){
            return city.get();
        }else{
            throw new ResourceNotFoundException("Record not found with id: "+ id);
        }

    }

    @Override
    public void deleteCity(Long id) {
        Optional<City> city=cityRepository.findById(id);

        if (city.isPresent()){
            cityRepository.delete(city.get());
        }else{
            throw new ResourceNotFoundException("Record not found with id: "+ id);
        }

    }
}
