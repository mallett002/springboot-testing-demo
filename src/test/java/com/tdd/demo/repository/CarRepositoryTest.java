package com.tdd.demo.repository;

import com.tdd.demo.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findByName_returnsCarDetails() throws Exception {
        Car savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));
        Car car = repository.findByName("prius");

        Assertions.assertThat(car.getName()).isEqualTo(savedCar.getName());
        Assertions.assertThat(car.getType()).isEqualTo(savedCar.getType());
    }
}