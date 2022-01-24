package com.bilgeadam.personelapp.pojo;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonelPojo {


    long id;
    String name;
    String surname;
    DepertmantPojo depertmant;
}
