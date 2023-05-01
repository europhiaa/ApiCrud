package com.europhia.apicrud.repositories;

import com.europhia.apicrud.entities.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage, Integer> {
}
