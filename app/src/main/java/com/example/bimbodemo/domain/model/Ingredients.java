package com.example.bimbodemo.domain.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ingredients {

    private List<Malt> malt;
    private List<Hop> hops;
    private String yeast;

    public List<Malt> getMalt() {
        return malt;
    }

    public void setMalt(List<Malt> malt) {
        this.malt = malt;
    }

    public List<Hop> getHops() {
        return hops;
    }

    public void setHops(List<Hop> hops) {
        this.hops = hops;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

}
