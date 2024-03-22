package com.example.bimbodemo.data.repository;

import com.example.bimbodemo.data.network.BeerService;
import com.example.bimbodemo.domain.model.Results;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Call;

public class BeerRepository {
    public BeerService beerService;
    @Inject
    public BeerRepository(BeerService beerService) {
        this.beerService = beerService;
    }

    public Observable<List<Results>> getBeers() {

        return beerService.getBeers();
    }

}
