package com.meteorology.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    @Getter @Setter
    private String unit;

    @Getter @Setter
    private String direction;

    @Getter @Setter
    @JsonProperty("min")
    private int minimumSpeed;

    @Getter @Setter
    @JsonProperty("max")
    private int maximumSpeed;

    @Getter @Setter
    @JsonProperty("avg")
    private int averageSpeed;

    @Getter @Setter
    private boolean significationWind;

    @Getter @Setter
    Gusts gusts;
}
