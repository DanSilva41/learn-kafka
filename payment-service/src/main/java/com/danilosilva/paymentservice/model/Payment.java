package com.danilosilva.paymentservice.model;

import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Payment implements Serializable {

    private final String id = UUID.randomUUID().toString();
    private Integer userId;
    private Integer productId;
    private String cardNumber;
}
