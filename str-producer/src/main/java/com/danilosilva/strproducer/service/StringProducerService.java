package com.danilosilva.strproducer.service;

import static com.danilosilva.strproducer.support.Constant.STR_TOPIC_NAME;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final String message) {
        this.kafkaTemplate.send(STR_TOPIC_NAME, message).addCallback(
            success -> {
                if (Objects.nonNull(success)) {
                    log.info("Send message with success: {}", message);
                    log.info("Partition {}, Offset: {}",
                        success.getRecordMetadata().partition(),
                        success.getRecordMetadata().offset());
                }
            },
            error -> log.error("Error send message: {0}", error)
        );
    }
}
