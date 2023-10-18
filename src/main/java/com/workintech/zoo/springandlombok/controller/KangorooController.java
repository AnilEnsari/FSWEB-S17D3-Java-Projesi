package com.workintech.zoo.springandlombok.controller;

import com.workintech.zoo.springandlombok.entity.Kangoroo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/kangaroos")
public class KangorooController {

    Map<Integer, Kangoroo> kangoroos;
@PostConstruct
    public void init() {
        kangoroos = new HashMap<>();
    }

    @GetMapping("/")
    public List<Kangoroo> findAll() {
        return kangoroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangoroo find(@PathVariable int id) {
        return kangoroos.get(id);

    }
    @PostMapping("/")
    public Kangoroo save(@RequestBody Kangoroo kangoroo){
        kangoroos.put(kangoroo.getId(),kangoroo);
        return kangoroo;

    }
    @PutMapping("/{id}")
    public Kangoroo update(@PathVariable int id , @RequestBody Kangoroo kangoroo){
        kangoroos.put(id,kangoroo);
        return kangoroo;

    }
    @DeleteMapping("/{id}")
    public Kangoroo delete(@PathVariable int id){
       Kangoroo deletedKangoroo = kangoroos.get(id);
       kangoroos.remove(id);
       return  deletedKangoroo;

    }


}
