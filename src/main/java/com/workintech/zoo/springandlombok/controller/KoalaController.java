package com.workintech.zoo.springandlombok.controller;

import com.workintech.zoo.springandlombok.entity.Koala;
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

        return koalas.get(id);
    }
    @PostMapping
    public Koala save(@RequestBody Koala koala){
        koalas.put(koala.getId(),koala);
        return koala;
    }
    @PutMapping("/{id}")
    public Koala update(int id,Koala koala){
        koalas.put(id,koala);
        return koala;
    }
    @DeleteMapping("/{id}")
    public Koala delete (int id){
      Koala deletedKoala = koalas.get(id);
      koalas.remove(id);
      return deletedKoala;

    }
}
