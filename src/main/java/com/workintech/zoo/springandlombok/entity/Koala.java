package com.workintech.zoo.springandlombok.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Koala {
    int id ;
    String name;
    double weight;
    double sleepHour;
    String gender ;
}
