package com.europhia.apicrud.services;

import com.europhia.apicrud.entities.CarEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {

    CarEntity addCar(CarEntity param);

    List<CarEntity> getAllCar();

    CarEntity getById(int id);

    CarEntity updateCar(CarEntity param);

    void deleteCar(int id);
}
