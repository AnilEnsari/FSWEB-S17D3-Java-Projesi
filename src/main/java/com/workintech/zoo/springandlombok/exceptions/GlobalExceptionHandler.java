package com.workintech.zoo.springandlombok.exceptions;

import com.workintech.zoo.springandlombok.exceptions.kangorooexceptions.KangorooErrorResponse;
import com.workintech.zoo.springandlombok.exceptions.kangorooexceptions.KangorooException;
import com.workintech.zoo.springandlombok.exceptions.koalaexceptions.KoalaErrorResponse;
import com.workintech.zoo.springandlombok.exceptions.koalaexceptions.KoalaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<KangorooErrorResponse>handleException(KangorooException exception){
        KangorooErrorResponse response = new KangorooErrorResponse(
                exception.getStatus().value(),exception.getMessage(),System.currentTimeMillis()
        );
        return new ResponseEntity<>(response,exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<KoalaErrorResponse>handleException(KoalaException exception){
        KoalaErrorResponse response = new KoalaErrorResponse(
                exception.getStatus().value(),exception.getMessage(),System.currentTimeMillis()
        );
        return new ResponseEntity<>(response,exception.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity<KangorooErrorResponse>handleException(Exception exception){
        KangorooErrorResponse response = new KangorooErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(),System.currentTimeMillis()
        ) ;
        log.error(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



}
