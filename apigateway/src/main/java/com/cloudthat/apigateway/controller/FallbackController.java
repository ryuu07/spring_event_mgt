package com.cloudthat.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/eventServiceFallBack")
    public String eventServiceFallback(){
        return "Event Service is DOWN!";
    }

    @GetMapping("/venueServiceFallBack")
    public String venueServiceFallBack(){
        return "Venue Service is DOWN!";
    }

}
