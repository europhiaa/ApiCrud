package com.europhia.apicrud.services;

import com.europhia.apicrud.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductService {

    List<ProductEntity> getAllProduct();
}
