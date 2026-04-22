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
    public List<FuelShedDto> getAllFuelSheds() {
        return fuelShedRepository.getAllFuelSheds();
    }

    @Override
    public FuelShedDto getFuelShedById(Long id) {
        FuelShedDto fuelShed = fuelShedRepository.findById(id);
        if (fuelShed == null) {
            throw new RuntimeException("Fuel shed not found with id: " + id);
        }
        return fuelShed;
    }

    @Override
    public boolean createFuelShed(FuelShedDto fuelShedDto) {
        int result = fuelShedRepository.save(fuelShedDto);
        return result > 0;
    }

    @Override
    public boolean updateFuelShed(Long id, FuelShedDto fuelShedDto) {
        FuelShedDto existingFuelShed = fuelShedRepository.findById(id);
        if (existingFuelShed != null) {
            fuelShedDto.setId(id);
            int result = fuelShedRepository.update(fuelShedDto);
            return result > 0;
        }
        return false;
    }

    @Override
    public boolean deleteFuelShed(Long id) {
        int result = fuelShedRepository.deleteById(id);
        return result > 0;
    }
}
