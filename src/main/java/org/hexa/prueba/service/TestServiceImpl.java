package org.hexa.prueba.service;

import lombok.RequiredArgsConstructor;
import org.hexa.prueba.entity.Test;
import org.hexa.prueba.repository.TestRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;
    @Override
    public Mono<List<Test>> findAll() {
        return testRepository.findAll()
                .collectList();
    }
}
