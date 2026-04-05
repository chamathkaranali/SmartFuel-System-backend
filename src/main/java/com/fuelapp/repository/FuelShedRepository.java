package com.fuelapp.repository;

import com.fuelapp.dto.FuelShedDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelShedRepository {
    int save(FuelShedDto fuelShedDto);
    List<FuelShedDto> findAll();
}
