package com.meteorology.response;

import lombok.Getter;
import lombok.Setter;

public class Location {

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String timezone;

    @Getter
    @Setter
    private Coordinates coordinates;

}
