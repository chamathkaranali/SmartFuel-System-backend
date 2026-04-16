package com.fuelapp.service;

import com.fuelapp.dto.FuelShedDto;
import java.util.List;

public interface FuelShedService {
    List<FuelShedDto> getAllFuelSheds();
    FuelShedDto getFuelShedById(Long id);
    boolean createFuelShed(FuelShedDto fuelShedDto);
    boolean updateFuelShed(Long id, FuelShedDto fuelShedDto);
    boolean deleteFuelShed(Long id);
}
