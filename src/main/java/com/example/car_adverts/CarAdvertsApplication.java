//package com.example.car_adverts;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class CarAdvertsApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(CarAdvertsApplication.class, args);
//	}
//
//}

package com.example.car_adverts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarAdvertsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarAdvertsApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseConnection(JdbcTemplate jdbcTemplate) {
		return args -> {
			String sql = "SELECT 1";
			Integer result = jdbcTemplate.queryForObject(sql, Integer.class);

			if (result != null && result == 1) {
				System.out.println("The connection to the database was successful!");
			} else {
				System.out.println("Something went wrong with the connection!");
			}
		};
	}
}