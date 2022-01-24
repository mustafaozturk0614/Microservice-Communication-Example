package com.bilgeadam.personelapp.service;

import com.bilgeadam.personelapp.entities.Personel;
import com.bilgeadam.personelapp.exception.ResourceNotFoundException;
import com.bilgeadam.personelapp.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonelServiceImpl implements PersonelService {
    @Autowired
    private PersonelRepository repository;

    @Override
    public Personel createPersonel(Personel personel) {
        return repository.save(personel);
    }

    @Override
    public Personel updatePersonel(Personel personel) {
        Optional<Personel> personeldB=repository.findById(personel.getId());

        if (personeldB.isPresent()){
            Personel personelUpdate=personeldB.get();
            personelUpdate.setId(personel.getId());
            personelUpdate.setName(personel.getName());
            personelUpdate.setSurname(personel.getSurname());
            personelUpdate.setDepertmantId(personelUpdate.getDepertmantId());
            return repository.save(personelUpdate);
        }else {

            throw new ResourceNotFoundException("Record not found with id: "+ personel.getId());
        }
    }

    @Override
    public List<Personel> getAllPersonels() {
        return repository.findAll();
    }

    @Override
    public Personel findPersonelById(Long id) {
        Optional<Personel> personeldB=repository.findById(id);

        if (personeldB.isPresent()){
           return personeldB.get();

        }else {

            throw new ResourceNotFoundException("Record not found with id: "+ id);
        }
    }

    @Override
    public void deletePersonel(Long id) {

        Optional<Personel> personel=repository.findById(id);

        if (personel.isPresent()){
            repository.delete(personel.get());
        }else{
            throw new ResourceNotFoundException("Record not found with id: "+ id);
        }

    }

    }

