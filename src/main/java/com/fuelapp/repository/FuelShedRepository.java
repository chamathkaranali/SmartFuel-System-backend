package com.fuelapp.repository;

import com.fuelapp.dto.FuelShedDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelShedRepository {
    List<FuelShedDto> getAllFuelSheds();
    int save(FuelShedDto fuelShedDto);
    FuelShedDto findById(Long id);
    int update(FuelShedDto fuelShedDto);
    int deleteById(Long id);
}
