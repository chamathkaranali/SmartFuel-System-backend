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

    private final RowMapper<FuelShedDto> stationRowMapper = (rs, rowNum) -> {
        return new FuelShedDto(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("location"),
                rs.getDouble("latitude"),
                rs.getDouble("longitude"),
                rs.getTimestamp("last_updated") != null ? rs.getTimestamp("last_updated").toLocalDateTime() : null
        );
    };

    @Override
    public List<FuelShedDto> getAllFuelSheds() {
        String sql = "SELECT * FROM fuel_sheds";
        return jdbcTemplate.query(sql, stationRowMapper);
    }

    @Override
    public int save(FuelShedDto fuelShedDto) {
        String sql = "INSERT INTO fuel_sheds (name, location, latitude, longitude, last_updated) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                fuelShedDto.getName(),
                fuelShedDto.getLocation(),
                fuelShedDto.getLatitude(),
                fuelShedDto.getLongitude(),
                fuelShedDto.getLastUpdated()
        );
    }

    @Override
    public FuelShedDto findById(Long id) {
        String sql = "SELECT * FROM fuel_sheds WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, stationRowMapper, id);
    }

    @Override
    public int update(FuelShedDto fuelShedDto) {
        String sql = "UPDATE fuel_sheds SET name = ?, location = ?, latitude = ?, longitude = ?, last_updated = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                fuelShedDto.getName(),
                fuelShedDto.getLocation(),
                fuelShedDto.getLatitude(),
                fuelShedDto.getLongitude(),
                fuelShedDto.getLastUpdated(),
                fuelShedDto.getId()
        );
    }

    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM fuel_sheds WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}