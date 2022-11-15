package com.danilosilva.paymentservice.controller;

import com.danilosilva.paymentservice.model.Payment;
import com.danilosilva.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface PaymentController {

    @PostMapping
    ResponseEntity<Void> payment(@RequestBody final Payment payment);
}

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
class PaymentControllerImpl implements PaymentController {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Void> payment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.ok().build();
    }
}
