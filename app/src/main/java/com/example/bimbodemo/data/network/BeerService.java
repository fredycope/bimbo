package com.example.bimbodemo.data.network;

import com.example.bimbodemo.domain.model.Results;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface BeerService {
    @GET("beers?page=1")
    Observable<List<Results>> getBeers();
}
