package com.example.bimbodemo.domain.usecase.beer;

import com.example.bimbodemo.data.repository.BeerRepository;
import com.example.bimbodemo.domain.model.Results;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Call;

public class GetBeersUseCase {
    BeerRepository repository;
    @Inject
    public GetBeersUseCase(BeerRepository repository) {
        this.repository = repository;
    }

    public Observable<List<Results>> getBeers() {
        return repository.getBeers();
    }
}
