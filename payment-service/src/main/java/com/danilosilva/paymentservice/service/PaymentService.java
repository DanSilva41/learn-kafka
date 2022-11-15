package com.danilosilva.paymentservice.service;

import static com.danilosilva.paymentservice.support.Constant.PAYMENT_TOPIC_NAME;

import com.danilosilva.paymentservice.model.Payment;
import java.io.Serializable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

public interface PaymentService {

    void sendPayment(Payment payment);
}

@RequiredArgsConstructor
@Slf4j
@Service
class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Pagamento recebido ::: {}", payment);

        Thread.sleep(1000);
        log.info("Enviando pagamento");
        kafkaTemplate.send(PAYMENT_TOPIC_NAME, payment);
        log.info("Pagamento enviado");
    }
}
