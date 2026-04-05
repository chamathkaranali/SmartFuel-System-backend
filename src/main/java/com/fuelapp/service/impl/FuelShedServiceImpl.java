package com.fuelapp.service.impl;

import com.fuelapp.dto.FuelShedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.fuelapp.repository.FuelShedRepository;
import com.fuelapp.service.FuelShedService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelShedServiceImpl implements FuelShedService {

    private final FuelShedRepository fuelShedRepository;

    @Override
    public String addFuelShed(FuelShedDto fuelShedDto) {
        int result = fuelShedRepository.save(fuelShedDto);
        return result > 0 ? "Fuel shed added successfully" : "Failed to add fuel shed";
    }

    @Override
    public List<FuelShedDto> getAllFuelSheds() {
        return fuelShedRepository.findAll();
    }
}
