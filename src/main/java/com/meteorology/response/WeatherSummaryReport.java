package com.meteorology.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherSummaryReport {

    @Getter
    @Setter
    private Location location;

    @Getter
    @Setter
    @JsonProperty("forecast")
    ForecastSummary forecast;

}
