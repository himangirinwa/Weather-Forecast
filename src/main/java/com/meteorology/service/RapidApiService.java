package com.meteorology.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meteorology.response.WeatherSummaryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RapidApiService {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rapid-api.base.url}")
    private String rapidApiBaseUrl;

    @Value("${rapid-api.host}")
    private String rapidApiHost;

    private final String rapidApiKey = "b58b1999bcmsh9418c67855dd841p1a94cdjsn60995cbf2210";

    private HttpHeaders headers;


    public RapidApiService(){
        headers = new HttpHeaders();
        this.setHttpHeaders();
    }

    private void setHttpHeaders(){
        headers.set("Content-Type", "application/json");
        headers.set("x-rapidapi-host", rapidApiHost);
        headers.set("x-rapidapi-key", rapidApiKey);
    }

    public WeatherSummaryReport getWeatherSummary(String city) throws JsonProcessingException {
        final String url = rapidApiBaseUrl + city + "/summary/";
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

        WeatherSummaryReport weatherSummary = mapper.readValue(response, WeatherSummaryReport.class);

        return weatherSummary;
    }

}
