package com.fuelapp.repository.impl;

import com.fuelapp.dto.FuelShedDto;
import com.fuelapp.repository.FuelShedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FuelShedRepositoryImpl implements FuelShedRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<FuelShedDto> rowMapper = (rs, rowNum) -> {
            FuelShedDto fuel = new FuelShedDto();
            fuel.setId(rs.getInt("id"));
            fuel.setName(rs.getString("name"));
            fuel.setLocation(rs.getString("location"));
            fuel.setLatitude(rs.getDouble("latitude"));
            fuel.setLongitude(rs.getDouble("longitude"));
            fuel.setLastUpdated(rs.getTimestamp("last_updated").toLocalDateTime());
            return fuel;
    };

    @Override
    public List<FuelShedDto> getAllCustomers() {
        String sql = "SELECT * FROM fuel_shed";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public boolean saveCustomer(FuelShedDto dto) {
        String sql = "INSERT INTO fuel_shed (name, location, latitude, longitude) VALUES (?,?,?,?)";
        int result = jdbcTemplate.update(sql,
                dto.getName(),
                dto.getLocation(),
                dto.getLatitude(),
                dto.getLongitude()
        );
        return result > 0;
    }

    @Override
    public Optional<FuelShedDto> searchFuelByPhone(String phone) {
        String sql = "SELECT * FROM fuel_shed WHERE location LIKE ?";
        return jdbcTemplate.query(sql, rowMapper, "%" + phone + "%").stream().findFirst();
    }

    @Override
    public Optional<FuelShedDto> searchFuelById(Integer id) {
        String sql = "SELECT * FROM fuel_shed WHERE id = ?";
        return jdbcTemplate.query(sql, rowMapper, id).stream().findFirst();
    }

    @Override
    public boolean deleteFuelByPhone(Integer id) {
        String sql = "DELETE FROM fuel_shed WHERE location LIKE ?";
        return jdbcTemplate.update(sql, "%" + id + "%") > 0;
    }

    @Override
    public boolean updateFuel(FuelShedDto fuelDto) {
        String sql = "UPDATE fuel_shed SET name = ?, location = ?, latitude = ?, longitude = ? WHERE id = ?";
        int result = jdbcTemplate.update(sql,
                fuelDto.getName(),
                fuelDto.getLocation(),
                fuelDto.getLatitude(),
                fuelDto.getLongitude(),
                fuelDto.getId()
        );
        return result > 0;
    }
}