package com.danilosilva.strconsumer.config;

import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class StringConsumerFactoryConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        final var configs = new HashMap<String, Object>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> strContainerFactory(
        final ConsumerFactory<String, String> consumerFactory
    ) {
        final var kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        return kafkaListenerContainerFactory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> strValidMessageContainerFactory(
        final ConsumerFactory<String, String> consumerFactory
    ) {
        final var kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        kafkaListenerContainerFactory.setRecordInterceptor(validMessage());
        return kafkaListenerContainerFactory;
    }

    private RecordInterceptor<String, String> validMessage() {
        return consumerRecord -> {
            if (consumerRecord.value().contains("Teste")) {
                log.info("Possui a palavra teste");
            }
            return consumerRecord;
        };
    }

}
