package com.fuelapp.service;

import com.fuelapp.dto.FuelShedDto;
import java.util.List;

public interface FuelShedService {
    String addFuelShed(FuelShedDto fuelShedDto);
    List<FuelShedDto> getAllFuelSheds();
}
