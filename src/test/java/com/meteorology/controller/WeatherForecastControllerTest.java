package com.meteorology.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meteorology.exception.GlobalExceptionHandler;
import com.meteorology.response.WeatherSummaryReport;
import com.meteorology.service.RapidApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.FileCopyUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

import java.io.File;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = WeatherForecastRestController.class)
@ContextConfiguration(classes = {WeatherForecastRestController.class, GlobalExceptionHandler.class, WeatherSummaryReport.class})

public class WeatherForecastControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RapidApiService rapidApiService;

    @Autowired
    ObjectMapper mapper;

    @Test
    void testWelcome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/forecast/welcome")
                        .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome!!"));
    }

    @Test
    void testGetWeatherSummary() throws Exception {
        String city = "Berlin";

        WeatherSummaryReport weatherReport = mapper.readValue(new File("src/test/resources/WeatherSummaryReport.json"), WeatherSummaryReport.class);

        Reader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("ExpectedWeatherSummaryReport.json").getInputStream()));
        String expectedJson = FileCopyUtils.copyToString(reader);

        when(rapidApiService.getWeatherSummary(city)).thenReturn(weatherReport);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/forecast/summary/{city}", city)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}