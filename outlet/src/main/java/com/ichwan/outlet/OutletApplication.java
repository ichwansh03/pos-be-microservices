package com.ichwan.outlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OutletApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutletApplication.class, args);
	}

}
