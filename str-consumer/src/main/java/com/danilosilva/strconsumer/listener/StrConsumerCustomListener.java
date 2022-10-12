package com.danilosilva.strconsumer.listener;

import static com.danilosilva.strconsumer.support.Constant.STR_TOPIC_NAME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface StrConsumerCustomListener {

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId();

    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default STR_TOPIC_NAME;

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

}
