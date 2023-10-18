package com.workintech.zoo.springandlombok.controller;

import com.workintech.zoo.springandlombok.entity.Kangoroo;
import com.workintech.zoo.springandlombok.entity.Koala;
import com.workintech.zoo.springandlombok.exceptions.kangorooexceptions.KangorooValidiation;
import com.workintech.zoo.springandlombok.exceptions.koalaexceptions.KoalaValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/workintech/koalas")
public class KoalaController {
    Map< Integer, Koala> koalas;


    @PostConstruct
    public void init (){
        koalas = new HashMap<>();
    }

    @GetMapping("/")
    public List<Koala> findAll(){

        return koalas.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Koala find(@PathVariable int id){
       KoalaValidation.isIdNotValid(id);
        KoalaValidation.isKoalaExist(koalas,id);
        return koalas.get(id);
    }
    @PostMapping("/")
    public Koala save(@RequestBody Koala koala){
        KoalaValidation.isKoalaExist(koalas, koala.getId());
        KoalaValidation.isKoalaCredentialsValid(koala);
        KoalaValidation.isIdNotValid(koala.getId());
        koalas.put(koala.getId(),koala);
        return koala;
    }
    @PutMapping("/{id}")
    public Koala update(int id,Koala koala){
     KoalaValidation.isKoalaCredentialsValid(koala);
        KoalaValidation.isIdNotValid(koala.getId());
        KoalaValidation.isIdNotValid(id);
        KoalaValidation.isKoalaNotExist(koalas,id);
        koalas.put(id,koala);
        return koala;
    }
    @DeleteMapping("/{id}")
    public Koala delete (int id){
        KoalaValidation.isIdNotValid(id);
        KoalaValidation.isKoalaNotExist(koalas,id);
      Koala deletedKoala = koalas.get(id);
      koalas.remove(id);
      return deletedKoala;

    }
}
