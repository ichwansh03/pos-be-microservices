package com.ichwan.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	/**
	 * Configures the routes for the Spring Cloud Gateway.
	 *
	 * @param builder the RouteLocatorBuilder used to build the routes
	 * @return a RouteLocator containing the configured routes
	 */
	@Bean
	public RouteLocator routeConfig(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/ichwan/outlet/**")
						.filters(f -> f.rewritePath("/ichwan/outlet/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://OUTLET"))
				.route(p -> p
						.path("/ichwan/employee/**")
						.filters(f -> f.rewritePath("/ichwan/employee/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://EMPLOYEE")).build();
	}
}
