package com.bilgeadam.cityapp.repository;

import com.bilgeadam.cityapp.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
