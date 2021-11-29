package com.dzinevihc.brewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalhostRoutesConfig {

    @Bean
    public RouteLocator localHostRoutesConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/v2/beer*", "/v2/beer/*", "/v2/beerUpc/*")
                            .uri("http://localhost:8081"))
                .route(r -> r.path("/api/v1/customers/**")
                        .uri("http://localhost:8083"))
                .build();
    }
}
