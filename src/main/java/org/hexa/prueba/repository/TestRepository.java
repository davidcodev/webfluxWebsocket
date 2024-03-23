package org.hexa.prueba.repository;

import org.hexa.prueba.entity.Test;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TestRepository extends ReactiveCrudRepository<Test, Long> {

}
