package com.meteorology.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReport {

    @Getter @Setter
    @JsonProperty("dateWithTimezone")
    private String date;

    @Getter @Setter
    private int FreshSnow;

    @Getter @Setter
    private int snowHeight;

    @Getter @Setter
    private int sunHours;

    @Getter @Setter
    @JsonProperty("temptrature")
    Temptrature temptratureDetails;

    @Getter @Setter
    Wind wind;
}
