package com.example.microservice.currencyexchangemicroservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CircuitBreakerController {

private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    //@CircuitBreaker(name = "default",fallbackMethod = "hardcodedResponse")
    @GetMapping("/sample-api")
@RateLimiter(name = "default")
    //2 calls in 10s period
    public String sampleApi(){

        logger.info("Sample Api called recieved");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http//localhost:8080/some-dummy-url", String.class);
    return forEntity.getBody();
}
public String hardcodedResponse(Exception ex){
        return "fallback-response";

}
}
