package com.meteorology.config;

import com.meteorology.service.RapidApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /*
    * Creating a RestTemplate Bean
    * RestTemplate is used to make HTTP web requests to Rapid API to fetch weather forecast
    * */
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
