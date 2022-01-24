package com.bilgeadam.personelapp.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepertmantPojo {
    long id;
    String name;
    CityPojo city;
}
