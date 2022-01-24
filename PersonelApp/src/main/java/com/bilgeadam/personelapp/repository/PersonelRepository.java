package com.bilgeadam.personelapp.repository;

import com.bilgeadam.personelapp.entities.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelRepository extends JpaRepository<Personel,Long> {
}
