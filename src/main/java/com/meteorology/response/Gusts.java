package com.meteorology.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Gusts {

    @Getter @Setter
    private int value;

    @Getter @Setter
    private String text;

}
