package com.bilgeadam.cityapp.controller;

import com.bilgeadam.cityapp.entities.City;
import com.bilgeadam.cityapp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CityContoller {
    @Autowired
    private CityService service;
    @GetMapping("/city")
    public List<City> getAllCities(){

        return service.getAllCities();
    }
    @GetMapping("/city/{id}")//
    public ResponseEntity<City>   getOneCity(@PathVariable ("id") Long id){

        return  new ResponseEntity<City> (service.findCityById(id), HttpStatus.OK) ;
    }

    @PostMapping("/city")
    public ResponseEntity<City> createCity(@RequestBody City city){


        return  new ResponseEntity<City>(service.createCity(city), HttpStatus.OK);
    }


    @PutMapping("/city/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id   ,  @RequestBody City city){

        city.setId(id);
        return  new ResponseEntity<City>(service.updateCity(city), HttpStatus.OK);
    }

    @DeleteMapping("/city/{id}")
    public HttpStatus deleteCity(@PathVariable Long id){

        service.deleteCity(id);

        return HttpStatus.OK;
    }


}
