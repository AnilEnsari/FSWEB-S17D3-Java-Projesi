package com.workintech.zoo.springandlombok.exceptions.kangorooexceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class KangorooException extends RuntimeException {
    private HttpStatus status;

    public KangorooException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }
}
