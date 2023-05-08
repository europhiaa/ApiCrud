package com.europhia.apicrud.repositories;

import com.europhia.apicrud.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
