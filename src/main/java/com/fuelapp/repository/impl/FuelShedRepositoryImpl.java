package com.fuelapp.repository.impl;

import com.fuelapp.dto.FuelShedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.fuelapp.repository.FuelShedRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FuelShedRepositoryImpl implements FuelShedRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int save(FuelShedDto fuelShedDto) {
        return jdbcTemplate.update("INSERT INTO fuel_shed (shed_name, location) VALUES (?, ?)",
                fuelShedDto.getShedName(), fuelShedDto.getShedLocation()
        );
    }

    @Override
    public List<FuelShedDto> findAll() {
        return jdbcTemplate.query("SELECT shed_id, shed_name, location FROM fuel_shed", (rs, rowNum) -> new FuelShedDto(
                rs.getInt("shed_id"),
                rs.getString("shed_name"),
                rs.getString("location")
            )
        );
    }
}
