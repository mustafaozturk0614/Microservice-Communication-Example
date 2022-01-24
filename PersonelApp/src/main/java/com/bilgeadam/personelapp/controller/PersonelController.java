package com.bilgeadam.personelapp.controller;

import com.bilgeadam.personelapp.entities.Personel;
import com.bilgeadam.personelapp.pojo.CityPojo;
import com.bilgeadam.personelapp.pojo.DepertmantPojo;
import com.bilgeadam.personelapp.pojo.PersonelPojo;
import com.bilgeadam.personelapp.service.PersonelService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
public class PersonelController {

    private EurekaClient client;
    private PersonelService service;
    @Autowired
    public PersonelController(EurekaClient client, PersonelService service) {
        this.client = client;
        this.service = service;
    }

    @GetMapping("/personel")
    public List<Personel> getAllPersonels(){

        return service.getAllPersonels();
    }
    @GetMapping("/personel/{id}")
    public ResponseEntity<Personel> getOnePersonel(@PathVariable("id") Long id){

        return  new ResponseEntity<Personel> (service.findPersonelById(id), HttpStatus.OK) ;
    }

    @PostMapping("/personel")
    public ResponseEntity<Personel> createPersonel(@RequestBody Personel personel){


        return  new ResponseEntity<Personel>(service.createPersonel(personel), HttpStatus.OK);
    }


    @PutMapping("/personel/{id}")
    public ResponseEntity<Personel> updatePersonel(@PathVariable Long id   ,  @RequestBody Personel personel){

        personel.setId(id);
        return  new ResponseEntity<Personel>(service.updatePersonel(personel), HttpStatus.OK);
    }

    @DeleteMapping("/personel/{id}")
    public HttpStatus deletePersonel(@PathVariable Long id){

        service.deletePersonel(id);

        return HttpStatus.OK;
    }

    @GetMapping("/personels/{id}")
    public ResponseEntity<PersonelPojo> getOneDepatmant(@PathVariable("id") Long id){
        Personel personel=service.findPersonelById(id);
        PersonelPojo personelPojo=new PersonelPojo();
        DepertmantPojo depertmantPojo=new DepertmantPojo();
        RestTemplate restTemplate=new RestTemplate();
        InstanceInfo instanceInfo1=client.getNextServerFromEureka("boost-depertmant-app",false);
        String depertmantUrl=instanceInfo1.getHomePageUrl();
        depertmantUrl=depertmantUrl+"/depertmant/"+personel.getDepertmantId();
        depertmantPojo=restTemplate.getForObject(depertmantUrl,DepertmantPojo.class);
        personelPojo.setName(personel.getName());
        personelPojo.setId(personel.getId());
        personelPojo.setSurname(personel.getSurname());
        personelPojo.setDepertmant(depertmantPojo);
        return  new ResponseEntity<PersonelPojo> (personelPojo,HttpStatus.OK) ;
    }




}
