package com.danilosilva.transactionconsumer.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Payment implements Serializable {

    private String id;
    private Integer userId;
    private Integer productId;
    private String cardNumber;
}
