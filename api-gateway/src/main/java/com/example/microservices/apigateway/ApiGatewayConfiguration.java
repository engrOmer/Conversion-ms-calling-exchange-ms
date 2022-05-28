package com.example.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//        Function<PredicateSpec, Buildable<Route>> routeFunction = a -> a.path("/get")
//                .filters(f->f.addRequestHeader("MyHeader","MyURI")
//                .addRequestHeader("Param","MyValue"))
//                .uri("http://httpbin.org:88");
//

        Function<PredicateSpec, Buildable<Route>> routeFunction2 = a -> a.path("/currency-exchange/**")
                .uri("lb://currency-exchange");


        return builder.routes().route(a -> a.path("/currency-exchange/**")
                .uri("lb://currency-exchange"))
                .build();

    }
}
