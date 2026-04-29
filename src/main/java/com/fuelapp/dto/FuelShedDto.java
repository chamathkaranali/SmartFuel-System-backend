package com.fuelapp.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuelShedDto {
    private int id;
    private String name;
    private String location;
    private Double latitude;
    private Double longitude;
    private LocalDateTime lastUpdated;
}
