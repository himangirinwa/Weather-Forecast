package com.meteorology.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meteorology.response.WeatherSummaryReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.mockito.Mockito.*;


public class RapidApiServiceTest {

    @Mock
    private ObjectMapper mapper;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RapidApiService rapidApiService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetWeatherSummary_Success() throws IOException {
        // Arrange
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("x-rapidapi-host", "mockHost");
        headers.set("x-rapidapi-key", "mockKey");

        Reader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("ExpectedWeatherSummaryReport.json").getInputStream()));
        String weatherReport = FileCopyUtils.copyToString(reader);
        ResponseEntity<String> mockResponseEntity = ResponseEntity.ok(weatherReport);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(String.class))).thenReturn(mockResponseEntity);

        WeatherSummaryReport weatherSummary = rapidApiService.getWeatherSummary("Berlin");

        verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(String.class));
    }

}
