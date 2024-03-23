package org.hexa.prueba.service;

import org.hexa.prueba.entity.Test;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TestService {
    Mono<List<Test>> findAll();
}
