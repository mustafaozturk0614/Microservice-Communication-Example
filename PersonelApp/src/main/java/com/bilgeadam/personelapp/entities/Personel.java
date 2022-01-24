package com.bilgeadam.personelapp.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Personel {
    @Id
    long id;
    String name;
    String surname;
    long depertmantId;

}
