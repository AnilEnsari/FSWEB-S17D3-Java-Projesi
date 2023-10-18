package com.workintech.zoo.springandlombok.exceptions.koalaexceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KoalaErrorResponse {
    private int status ;
    private String message;
    private long timestamp ;
}
