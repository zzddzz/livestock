package com.east.sword.livestock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LivestockApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivestockApplication.class, args);
	}

}
