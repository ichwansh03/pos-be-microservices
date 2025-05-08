package com.ichwan.gatewayserver;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
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
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("outletCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://OUTLET"))
				.route(p -> p
						.path("/ichwan/employee/**")
						.filters(f -> f.rewritePath("/ichwan/employee/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://EMPLOYEE")).build();
	}


	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build())
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
				.build());
	}

}
