package com.example.bimbodemo.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Amount {

    private Double value;
    private String unit;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
