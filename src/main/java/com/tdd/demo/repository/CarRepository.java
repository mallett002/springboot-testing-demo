package com.tdd.demo.repository;

import com.tdd.demo.domain.Car;
import org.springframework.data.repository.CrudRepository;


public interface CarRepository extends CrudRepository<Car, Long> {
    Car findByName(String name);
    Car save(Car car);
}
