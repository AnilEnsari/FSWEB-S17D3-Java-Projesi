package com.workintech.zoo.springandlombok.exceptions.koalaexceptions;

import com.workintech.zoo.springandlombok.entity.Koala;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class KoalaValidation {
    public static void isIdNotValid(int id) {


        if (id <= 0) {
            throw new KoalaException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKoalaNotExist(Map<Integer, Koala> koalas, int id) {

        if (!koalas.containsKey(id)) {
            throw new KoalaException("Koala with given id is not exist: " + id, HttpStatus.NOT_FOUND);
        }
    }

    public static void isKoalaExist(Map<Integer, Koala> koalas, int id) {
        if (koalas.containsKey(id)) {
            throw new KoalaException("Koala with given id already exist: " + id, HttpStatus.BAD_REQUEST);
        }
    }
    public static void isKoalaCredentialsValid(Koala koala){
        if((koala.getName()==null)){
            throw new KoalaException("You must enter the name of the koala",HttpStatus.BAD_REQUEST);
        }
    }
}
