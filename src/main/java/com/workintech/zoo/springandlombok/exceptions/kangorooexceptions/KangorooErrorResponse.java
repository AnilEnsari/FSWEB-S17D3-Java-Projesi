package com.workintech.zoo.springandlombok.exceptions.kangorooexceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class KangorooErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
