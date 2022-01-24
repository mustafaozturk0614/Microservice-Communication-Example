package com.bilgeadam.departmantapp.service;

import com.bilgeadam.departmantapp.entites.Departmant;

import java.util.List;

public interface DepartmantService {

    Departmant createDepartmant(Departmant departmant);
    Departmant updateDepartmant(Departmant departmant);
    List<Departmant> getAllDepartmants();
    Departmant findDepartmantById(Long id);
    void deleteCity(Long id);
}
