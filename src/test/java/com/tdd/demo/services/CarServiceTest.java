package com.tdd.demo.services;

import com.tdd.demo.domain.Car;
import com.tdd.demo.exceptions.CarNotFoundException;
import com.tdd.demo.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

// Unit testing this service without involving Spring
// (@MockBean & RunWith(SpringRunner.class) both involve Spring; Not using those here.
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() throws Exception {
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails_returnsCarInfo() {
        given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));

        Car result = carService.getCarDetails("prius");

        assertThat(result.getName()).isEqualTo("prius");
        assertThat(result.getType()).isEqualTo("hybrid");
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound() throws Exception {
        carService.getCarDetails("");
    }
}