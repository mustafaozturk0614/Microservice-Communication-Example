package com.bilgeadam.departmantapp.entites;

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
public class Departmant {
    @Id
    long id;
    String name;
    long cityId;

}
