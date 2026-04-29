package com.fuelapp.repository;

import com.fuelapp.dto.FuelShedDto;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FuelShedRepository {
    List<FuelShedDto> getAllCustomers();
    boolean saveCustomer(FuelShedDto dto);
    Optional<FuelShedDto> searchFuelByPhone(String phone);
    Optional<FuelShedDto> searchFuelById(Integer id);
    boolean deleteFuelByPhone(Integer id);
    boolean updateFuel(FuelShedDto fuelDto);
}
