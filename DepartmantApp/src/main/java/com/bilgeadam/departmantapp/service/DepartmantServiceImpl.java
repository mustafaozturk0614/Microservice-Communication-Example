package com.bilgeadam.departmantapp.service;

import com.bilgeadam.departmantapp.entites.Departmant;
import com.bilgeadam.departmantapp.exception.ResourceNotFoundException;
import com.bilgeadam.departmantapp.repository.DepertmantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class DepartmantServiceImpl implements DepartmantService {
    @Autowired
    private DepertmantRepository repository;
    @Override
    public Departmant createDepartmant(Departmant departmant) {
        return repository.save(departmant);
    }

    @Override
    public Departmant updateDepartmant(Departmant departmant) {

        Optional<Departmant> departmantdB=repository.findById(departmant.getId());

        if (departmantdB.isPresent()){
            Departmant departmantUpdate=departmantdB.get();
            departmantUpdate.setId(departmant.getId());
            departmantUpdate.setName(departmant.getName());
            departmantUpdate.setCityId(departmant.getCityId());

            return repository.save(departmantUpdate);
        }else {

            throw new ResourceNotFoundException("Record not found with id: "+ departmant.getId());
        }


    }

    @Override
    public List<Departmant> getAllDepartmants() {
        return repository.findAll();
    }

    @Override
    public Departmant findDepartmantById(Long id) {
        Optional<Departmant> departmantdB=repository.findById(id);

        if (departmantdB.isPresent()){
          return   departmantdB.get();

        }else {
            throw new ResourceNotFoundException("Record not found with id: "+ id);
        }
    }

    @Override
    public void deleteCity(Long id) {
        Optional<Departmant> departmantdB=repository.findById(id);

        if (departmantdB.isPresent()){
            repository.delete(departmantdB.get());
        }else{
            throw new ResourceNotFoundException("Record not found with id: "+ id);
        }

    }

    }

