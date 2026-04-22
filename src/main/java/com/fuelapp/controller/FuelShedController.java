package com.fuelapp.controller;

import com.fuelapp.dto.FuelShedDto;
import com.fuelapp.service.FuelShedService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sheds")
@CrossOrigin
@RequiredArgsConstructor
public class FuelShedController {

    private final FuelShedService fuelShedService;

    @GetMapping
    public List<FuelShedDto> getAllFuelSheds() {
        return fuelShedService.getAllFuelSheds();
    }

    @PostMapping
    public boolean addFuelShed(@Validated @RequestBody FuelShedDto fuelShedDto) {
        return fuelShedService.createFuelShed(fuelShedDto);
    }

    @GetMapping("/{id}")
    public FuelShedDto searchFuelShedById(@PathVariable Long id) {
        return fuelShedService.getFuelShedById(id);
    }

    @PutMapping("/{id}")
    public boolean updateFuelShed(@PathVariable Long id, @Validated @RequestBody FuelShedDto fuelShedDto) {
        return fuelShedService.updateFuelShed(id, fuelShedDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteFuelShed(@PathVariable Long id) {
        return fuelShedService.deleteFuelShed(id);
    }
}
