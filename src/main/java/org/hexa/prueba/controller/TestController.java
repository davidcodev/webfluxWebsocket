package org.hexa.prueba.controller;

import lombok.RequiredArgsConstructor;
import org.hexa.prueba.entity.Test;
import org.hexa.prueba.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public Mono<ResponseEntity<List<Test>>> findAll() {
        return testService.findAll()
                .map(ResponseEntity::ok);
    }
}
