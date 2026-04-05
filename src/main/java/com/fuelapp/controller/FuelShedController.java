package com.fuelapp.controller;

import com.fuelapp.dto.FuelShedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fuelapp.service.FuelShedService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sheds")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class FuelShedController {

    private final FuelShedService fuelShedService;

    @PostMapping("/save")
    public ResponseEntity<String> saveShed(@RequestBody FuelShedDto fuelShedDto) {
        String response = fuelShedService.addFuelShed(fuelShedDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<FuelShedDto> getAllSheds(){
        return fuelShedService.getAllFuelSheds();
    }
}
