package com.danilosilva.strconsumer.exception;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListenerCustomHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(@NonNull Message<?> message, @NonNull ListenerExecutionFailedException exception) {
        log.error("Exception handler ::: Get error");
        log.info("Payload ::: {}", message.getPayload());
        log.info("Headers ::: {}", message.getHeaders());
        log.info("Offset ::: {}", message.getHeaders().get("kafka_offset"));
        log.info("Message exception ::: {}", exception.getMessage());
        return null;
    }
}
