package com.workintech.zoo.springandlombok.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kangoroo {
    int id ;
    String name ;
    double height;
    double weight;
    String gender;
    boolean isAggressive ;
}
