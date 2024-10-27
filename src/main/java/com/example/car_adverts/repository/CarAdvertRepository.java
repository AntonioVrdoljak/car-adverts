package com.example.car_adverts.repository;

import com.example.car_adverts.model.CarAdvert;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;

@Repository
public class CarAdvertRepository {

    private final JdbcTemplate jdbcTemplate;

    public CarAdvertRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CarAdvert> findAll() {
        return jdbcTemplate.query("SELECT * FROM car_adverts", new CarAdvertRowMapper());
    }

    private static class CarAdvertRowMapper implements RowMapper<CarAdvert> {
        @Override
        public CarAdvert mapRow(ResultSet rs, int rowNum) throws SQLException {
            CarAdvert carAdvert = new CarAdvert();
            carAdvert.setId(rs.getInt("id"));
            carAdvert.setTitle(rs.getString("title"));
            carAdvert.setFuelType(rs.getString("fuelType"));
            carAdvert.setPrice(rs.getInt("price"));
            carAdvert.setNew(rs.getBoolean("isNew"));
            carAdvert.setMileage(rs.getObject("mileage", Integer.class)); // koristeći getObject za nullable int
            carAdvert.setFirstRegistration(rs.getObject("firstRegistration", LocalDate.class)); // pretpostavka da koristite LocalDate
            return carAdvert;
        }
    }
}