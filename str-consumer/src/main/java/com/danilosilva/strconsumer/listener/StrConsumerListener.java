package com.danilosilva.strconsumer.listener;

import static com.danilosilva.strconsumer.support.Constant.STR_TOPIC_NAME;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    @KafkaListener(
        groupId = "group-1",
        topics = STR_TOPIC_NAME,
        topicPartitions = {
            @TopicPartition(topic = STR_TOPIC_NAME, partitions = {"0"})
        },
        containerFactory = "strContainerFactory"
    )
    public void listener(final String message) {
        log.info("Receive message: {}", message);
    }

    @KafkaListener(
        groupId = "group-1",
        topics = STR_TOPIC_NAME,
        topicPartitions = {
            @TopicPartition(topic = STR_TOPIC_NAME, partitions = {"1"})
        },
        containerFactory = "strContainerFactory"
    )
    public void log(final String message) {
        log.info("LOG:: Receive message: {}", message);
    }

    @KafkaListener(
        groupId = "group-2",
        topics = STR_TOPIC_NAME,
        containerFactory = "strContainerFactory"
    )
    public void history(final String message) {
        log.info("HISTORY:: Receive message: {}", message);
    }
}
