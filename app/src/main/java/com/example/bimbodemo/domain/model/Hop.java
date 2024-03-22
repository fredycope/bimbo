package com.example.bimbodemo.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Hop {
    private String name;
    private Volume amount;
    private String add;
    private String attribute;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Volume getAmount() {
        return amount;
    }

    public void setAmount(Volume amount) {
        this.amount = amount;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

}
