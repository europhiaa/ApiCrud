package com.europhia.apicrud.controllers;

import com.europhia.apicrud.entities.CarEntity;
import com.europhia.apicrud.repositories.CarRepository;
import com.europhia.apicrud.response.CommonResponse;
import com.europhia.apicrud.response.CommonResponseGenerator;
import com.europhia.apicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value ="checkAPI")
    public String checkApi(){
        return "Hello Kaka";
    }

    @GetMapping(value ="checkAPIResponse")
    public CommonResponse<String> checkApiResponse(){
        return commonResponseGenerator.successResponse("Hello Kaka","Sukses cek api");
    }

    @PostMapping(value = "addNewCar")
    public CarEntity addNewCar(@RequestBody CarEntity param){
        CarEntity car = carService.addCar(param);
        return car;
    }

    @PostMapping(value = "addNewCarResponse")
    public CommonResponse<CarEntity> addNewCarResponse(@RequestBody CarEntity param){
        try{
            CarEntity car = carService.addCar(param);
            return commonResponseGenerator.successResponse(car, "sukses tambah data");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getAllCar")
    public List<CarEntity> getAllCar(){
        List<CarEntity> carList = carService.getAllCar();
        return carList;
    }

    @GetMapping(value = "getAllCarResponse")
    public CommonResponse<List<CarEntity>> getAllCarResponse(){
        try{
            List<CarEntity> carList = carService.getAllCar();
            return commonResponseGenerator.successResponse(carList,"Sukses tampil semua data");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getById")
    public CarEntity getById(@RequestParam int id){
        CarEntity car = carService.getById(id);
        return car;
    }

    @GetMapping(value = "getByIdResponse")
    public CommonResponse<CarEntity> getByIdResponse(@RequestParam int id){
        try{
            CarEntity car = carService.getById(id);
            return commonResponseGenerator.successResponse(car,"Sukses tampil id : "+id);
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }


    @PostMapping(value = "updateCar")
    public CarEntity updateCar(@RequestBody CarEntity param){
        CarEntity car = carService.updateCar(param);
        return car;
    }

    @PostMapping(value = "updateCarResponse")
    public CommonResponse<CarEntity> updateCarResponse(@RequestBody CarEntity param){
        try{
            CarEntity car = carService.updateCar(param);
            return commonResponseGenerator.successResponse(car, "Sukses update data id : "+param.getId());
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage()+ " for id : "+param.getId());
        }
    }

    @GetMapping(value = "deleteCar")
    public List<CarEntity> deleteCar(@RequestParam int id){
        carService.deleteCar(id);

        List<CarEntity> carList = carService.getAllCar();
        return carList;
    }

    @GetMapping(value = "deleteCarResponse")
    public CommonResponse<List<CarEntity>> deleteCarResponse(@RequestParam int id){
        try{
            carService.deleteCar(id);
            List<CarEntity> carList = carService.getAllCar();
            return commonResponseGenerator.successResponse(carList, "Sukses hapus data id : "+id);
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}
