package com.fuelapp.service;

import com.fuelapp.dto.FuelShedDto;
import java.util.List;

public interface FuelShedService {
    List<FuelShedDto> getAllShed();
    boolean addShed(FuelShedDto fuelShedDto);
    FuelShedDto searchShedByPhone(String phone);
    FuelShedDto searchShedById(Integer id);
    boolean deleteShedByPhone(Integer id);
    boolean updateShed(FuelShedDto fuelShedDto);
}
