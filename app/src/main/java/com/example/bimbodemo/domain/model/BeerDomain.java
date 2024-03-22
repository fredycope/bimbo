package com.example.bimbodemo.domain.model;

import androidx.room.ColumnInfo;

import com.example.bimbodemo.data.database.dbmodel.Beer;

public class BeerDomain {
    public Long beerId;

    public String name;
    public String imageUrl;
    public String tagline;
    public String description;

    public BeerDomain(Results res) {
        this.beerId = Long.valueOf(res.getId());
        this.name = res.getName();
        this.imageUrl = res.getImageUrl();
        this.tagline = res.getTagline();
        this.description = res.getDescription();
    }

    public BeerDomain(Beer res) {
        this.beerId = res.beerId;
        this.name = res.name;
        this.imageUrl = res.imageUrl;
        this.tagline = res.tagline;
        this.description = res.description;
    }
}
