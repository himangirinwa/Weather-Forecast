package com.meteorology.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temptrature {

    @Getter @Setter
    @JsonProperty("min")
    private int minimumTemptrature;

    @Getter @Setter
    @JsonProperty("max")
    private int maximumTemptrature;

    @Getter @Setter
    @JsonProperty("avg")
    private int averageTemptrature;
}
