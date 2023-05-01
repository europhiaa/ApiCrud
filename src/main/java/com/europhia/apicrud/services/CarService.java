package com.europhia.apicrud.services;

import com.europhia.apicrud.entities.CarEntity;
import com.europhia.apicrud.entities.CarImage;
import com.europhia.apicrud.wrappers.CarImageWrapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {

    CarEntity addCar(CarEntity param);

    List<CarEntity> getAllCar();

    CarEntity getById(int id);

    CarEntity updateCar(CarEntity param);

    void deleteCar(int id);

    CarImage upload(CarImageWrapper carImageWrapper);
}
