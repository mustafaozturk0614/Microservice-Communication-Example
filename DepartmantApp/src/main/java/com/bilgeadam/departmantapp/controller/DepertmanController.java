package com.bilgeadam.departmantapp.controller;

import com.bilgeadam.departmantapp.entites.Departmant;
import com.bilgeadam.departmantapp.pojo.City;
import com.bilgeadam.departmantapp.pojo.DepertmanPojo;
import com.bilgeadam.departmantapp.service.DepartmantService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController

public class DepertmanController {


    private DepartmantService service;
    private EurekaClient client;
    @Autowired
    public DepertmanController(DepartmantService service, EurekaClient client) {
        this.service = service;
        this.client = client;
    }

    @GetMapping("/depertmant")
    public List<Departmant> getAllDepertmant(){

        return service.getAllDepartmants();
    }
    @GetMapping("/depertmant/{id}")
    public ResponseEntity<DepertmanPojo> getOneDepatmant(@PathVariable("id") Long id){
        Departmant departmant=service.findDepartmantById(id);
        City city=null;
        RestTemplate restTemplate=new RestTemplate();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("boost-city-app",false);
        String courseAppUrl=instanceInfo.getHomePageUrl();
        courseAppUrl=courseAppUrl+"/city/"+departmant.getCityId();
        city=restTemplate.getForObject(courseAppUrl,City.class);
        DepertmanPojo depertmanPojo=new DepertmanPojo();
        depertmanPojo.setCity(city);
        depertmanPojo.setName(departmant.getName());
        depertmanPojo.setId(departmant.getId());

        return  new ResponseEntity<DepertmanPojo> (depertmanPojo,HttpStatus.OK) ;
    }

    @PostMapping("/depertmant")
    public ResponseEntity<Departmant> createDepertmant(@RequestBody Departmant city){


        return  new ResponseEntity<Departmant>(service.createDepartmant(city), HttpStatus.OK);
    }


    @PutMapping("/depertmant/{id}")
    public ResponseEntity<Departmant> updateDepertmant(@PathVariable Long id   , @RequestBody Departmant city){

        city.setId(id);
        return  new ResponseEntity<Departmant>(service.updateDepartmant(city), HttpStatus.OK);
    }

    @DeleteMapping("/depertmant/{id}")
    public HttpStatus deleteDepertmant(@PathVariable Long id){

        service.deleteCity(id);

        return HttpStatus.OK;
    }

    @GetMapping("/city/{id}")
    public City getOneCity(@PathVariable("id") Long id){


       City city=null;
        RestTemplate restTemplate=new RestTemplate();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("boost-city-app",false);
        String courseAppUrl=instanceInfo.getHomePageUrl();
        courseAppUrl=courseAppUrl+"/city/"+id;
        city=restTemplate.getForObject(courseAppUrl,City.class);

        return   city ;

    }


}
