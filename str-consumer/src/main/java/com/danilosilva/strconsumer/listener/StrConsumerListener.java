package com.danilosilva.strconsumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void listener(final String message) {
        log.info("Receive message: {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(final String message) {
        log.info("LOG:: Receive message: {}", message);
    }

    @StrConsumerCustomListener(
        groupId = "group-2",
        containerFactory = "strValidMessageContainerFactory"
    )
    public void history(final String message) {
        log.info("HISTORY:: Receive message: {}", message);
    }
}
