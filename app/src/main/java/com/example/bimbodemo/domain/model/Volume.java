package com.example.bimbodemo.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Volume {

    private double value;
    private String unit;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
