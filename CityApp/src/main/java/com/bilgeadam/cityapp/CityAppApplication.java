package com.bilgeadam.cityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CityAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityAppApplication.class, args);
    }

}
