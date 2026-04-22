package com.fuelapp.repository.impl;

import com.fuelapp.dto.FuelShedDto;
import com.fuelapp.repository.FuelShedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FuelShedRepositoryImpl implements FuelShedRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<FuelShedDto> fuelShedRowMapper = (rs, rowNum) -> {
        return new FuelShedDto(
                rs.getLong("shed_id"),
                rs.getString("shed_name"),
                rs.getString("location"),
                null,
                null,
                null
        );
    };

    @Override
    public List<FuelShedDto> getAllFuelSheds() {
        String sql = "SELECT shed_id, shed_name, location FROM fuel_shed";
        return jdbcTemplate.query(sql, fuelShedRowMapper);
    }

    @Override
    public int save(FuelShedDto fuelShedDto) {
        String sql = "INSERT INTO fuel_shed (shed_name, location) VALUES (?, ?)";
        return jdbcTemplate.update(sql,
                fuelShedDto.getName(),
                fuelShedDto.getLocation()
        );
    }

    @Override
    public FuelShedDto findById(Long id) {
        String sql = "SELECT shed_id, shed_name, location FROM fuel_shed WHERE shed_id = ?";
        return jdbcTemplate.queryForObject(sql, fuelShedRowMapper, id);
    }

    @Override
    public int update(FuelShedDto fuelShedDto) {
        String sql = "UPDATE fuel_shed SET shed_name = ?, location = ? WHERE shed_id = ?";
        return jdbcTemplate.update(sql,
                fuelShedDto.getName(),
                fuelShedDto.getLocation(),
                fuelShedDto.getId()
        );
    }

    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM fuel_shed WHERE shed_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}