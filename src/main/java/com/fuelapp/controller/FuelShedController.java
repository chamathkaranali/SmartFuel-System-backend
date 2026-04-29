package com.fuelapp.controller;

import com.fuelapp.dto.FuelShedDto;
import com.fuelapp.repository.FuelShedRepository;
import com.fuelapp.service.FuelShedService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/sheds")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class FuelShedController {

    private final FuelShedService fuelShedService;
    private final FuelShedRepository fuelShedRepository;

    @GetMapping
    public List<FuelShedDto> getAllCustomer(){
        return fuelShedService.getAllShed();
    }

    @PostMapping
    public boolean addCustomer(@Validated @RequestBody FuelShedDto fuelDto){
        return fuelShedService.addShed(fuelDto);
    }

    @GetMapping("/phone/{phone}")
    public FuelShedDto searchCustomerByPhone(@PathVariable String phone){
        return fuelShedService.searchShedByPhone(phone);
    }

    @GetMapping("/{id}")
    public FuelShedDto searchCustomerById(@PathVariable Integer id){
        return fuelShedService.searchShedById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCustomerByPhone(@PathVariable Integer id){
        return fuelShedService.deleteShedByPhone(id);
    }

    @PutMapping
    public boolean updateCustomer(@Validated @RequestBody FuelShedDto fuelDto){
        return fuelShedService.updateShed(fuelDto);
    }
}
