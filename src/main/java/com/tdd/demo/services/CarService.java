package com.tdd.demo.services;

import com.tdd.demo.domain.Car;
import com.tdd.demo.exceptions.CarNotFoundException;
import com.tdd.demo.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);

        if (car == null) {
            throw new CarNotFoundException();
        }

        return car;
    }
}
