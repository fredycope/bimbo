package com.example.bimbodemo.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class MashTemp {

    private Volume temp;
    private Integer duration;

    public Volume getTemp() {
        return temp;
    }

    public void setTemp(Volume temp) {
        this.temp = temp;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}
