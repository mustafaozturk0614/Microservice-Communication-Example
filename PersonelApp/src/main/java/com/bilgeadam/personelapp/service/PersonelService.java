package com.bilgeadam.personelapp.service;

import com.bilgeadam.personelapp.entities.Personel;

import java.util.List;

public interface PersonelService {

    Personel createPersonel(Personel personel);
    Personel updatePersonel(Personel personel);
    List<Personel> getAllPersonels();
    Personel findPersonelById(Long id);
    void deletePersonel(Long id);
}
