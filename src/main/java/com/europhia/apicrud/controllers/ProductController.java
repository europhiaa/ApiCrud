package com.europhia.apicrud.controllers;

import com.europhia.apicrud.entities.ProductEntity;
import com.europhia.apicrud.response.CommonResponse;
import com.europhia.apicrud.response.CommonResponseGenerator;
import com.europhia.apicrud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "getAllProduct")
    public CommonResponse<List<ProductEntity>> getAllProduct(){
        try{
            List<ProductEntity> carList = productService.getAllProduct();
            return commonResponseGenerator.successResponse(carList,"Sukses tampil semua data");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}
