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
    public List<FuelShedDto> getAllShed() {
        return fuelShedRepository.getAllCustomers();
    }

    @Override
    public boolean addShed(FuelShedDto fuelShedDto) {
        return fuelShedRepository.saveCustomer(fuelShedDto);
    }

    @Override
    public FuelShedDto searchShedByPhone(String phone) {
        return fuelShedRepository.searchFuelByPhone(phone).orElse(null);
    }

    @Override
    public FuelShedDto searchShedById(Integer id) {
        return fuelShedRepository.searchFuelById(id).orElse(null);
    }

    @Override
    public boolean deleteShedByPhone(Integer id) {
        return fuelShedRepository.deleteFuelByPhone(id);
    }

    @Override
    public boolean updateShed(FuelShedDto fuelShedDto) {
        return fuelShedRepository.updateFuel(fuelShedDto);
    }
}