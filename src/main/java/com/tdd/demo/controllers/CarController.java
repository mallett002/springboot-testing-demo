package com.tdd.demo.controllers;

import com.tdd.demo.domain.Car;
import com.tdd.demo.exceptions.CarNotFoundException;
import com.tdd.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

    @PostMapping("/car")
    private ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car savedCar = carService.insertCar(car);

        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {}
}
