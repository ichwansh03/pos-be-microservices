package com.ichwan.pos_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PosServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosServerApplication.class, args);
	}

}
