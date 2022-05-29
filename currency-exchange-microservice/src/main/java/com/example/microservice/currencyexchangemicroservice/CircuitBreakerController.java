package com.example.microservice.currencyexchangemicroservice;

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
    @Retry(name = "sample-api",fallbackMethod = "hardcodedResponse")
    @GetMapping("/sample-api")
public String sampleApi(){

        logger.info("Sample Api called recieved");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http//localhost:8080/some-dummy-url", String.class);
    return forEntity.getBody();
}
public String hardcodedResponse(Exception ex){
        return "fallback-response";

}
}