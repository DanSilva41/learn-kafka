package com.danilosilva.paymentservice.model;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class Payment implements Serializable {

    private Integer id;
    private Integer user;
    private Integer idProduct;
    private String cardNumber;
}
