package com.danilosilva.paymentservice.service;

import com.danilosilva.paymentservice.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

public interface PaymentService {

    void sendPayment(Payment payment);
}

@Slf4j
@Service
class PaymentServiceImpl implements PaymentService {

    @Override
    public void sendPayment(Payment payment) {
        log.info("Pagamento recebido [PaymentServiceImpl] ::: {}", payment.getId());
    }
}
