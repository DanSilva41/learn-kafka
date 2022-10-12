package com.danilosilva.strproducer.controller;

import com.danilosilva.strproducer.service.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/string-producer")
public class StringProducerController {

    private final StringProducerService stringProducerService;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody final String message) {
        stringProducerService.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
