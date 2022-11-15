package com.danilosilva.transactionconsumer.listener;

import static java.lang.Thread.sleep;

import com.danilosilva.transactionconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "validate-payment", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        log.info("Validando fraude do pagamento :: {}", payment);
        sleep(2000);

        log.info("Compra aprovada");
        sleep(1000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-payment", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        sleep(4000);
        log.info("Gerando PDF do pagamento :: {}", payment);
        log.info("PDF gerado");
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-payment", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment) {
        sleep(5000);
        log.info("Enviado de email de confirmação do pagamento :: {}", payment);
        log.info("Email enviado");
    }
}
