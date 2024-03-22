package com.example.bimbodemo.domain.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Method {

    private List<MashTemp> mashTemp;
    private Fermentation fermentation;
    private Object twist;


    public List<MashTemp> getMashTemp() {
        return mashTemp;
    }

    public void setMashTemp(List<MashTemp> mashTemp) {
        this.mashTemp = mashTemp;
    }

    public Fermentation getFermentation() {
        return fermentation;
    }

    public void setFermentation(Fermentation fermentation) {
        this.fermentation = fermentation;
    }

    public Object getTwist() {
        return twist;
    }

    public void setTwist(Object twist) {
        this.twist = twist;
    }

}
