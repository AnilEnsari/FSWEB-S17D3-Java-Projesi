package com.workintech.zoo.springandlombok.exceptions.kangorooexceptions;

import com.workintech.zoo.springandlombok.entity.Kangoroo;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class KangorooValidiation {
    public static void isIdNotValid(int id) {


        if (id <= 0) {
            throw new KangorooException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKangorooNotExist(Map<Integer, Kangoroo> kangoroos, int id) {

        if (!kangoroos.containsKey(id)) {
            throw new KangorooException("Kangoroo with given id is not exist: " + id, HttpStatus.NOT_FOUND);
        }
    }

    public static void isKangorooExist(Map<Integer, Kangoroo> kangoroos, int id) {
        if (kangoroos.containsKey(id)) {
            throw new KangorooException("Kangoroo with given id already exist: " + id, HttpStatus.BAD_REQUEST);
        }
    }
    public static void isKangorooCredentialsValid(Kangoroo kangoroo){
        if((kangoroo.getName()==null)){
            throw new KangorooException("You must enter the name of the kangoroo",HttpStatus.BAD_REQUEST);
        }
    }
}
