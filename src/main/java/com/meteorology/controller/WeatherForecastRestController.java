package com.meteorology.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteorology.response.WeatherSummaryReport;
import com.meteorology.service.RapidApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/forecast")
public class WeatherForecastRestController {

    @Autowired
    private RapidApiService rapidApiService;

    @GetMapping("/welcome")
    String printWelcome(){
        return "Welcome!!";
    }

    @GetMapping("/summary/{city}")
    WeatherSummaryReport getWeatherSummary(@PathVariable String city) throws JsonProcessingException {
        return rapidApiService.getWeatherSummary(city);
    }
}
