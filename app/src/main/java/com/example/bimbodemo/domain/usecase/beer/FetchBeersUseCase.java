package com.example.bimbodemo.domain.usecase.beer;

import com.example.bimbodemo.data.database.dbmodel.Beer;
import com.example.bimbodemo.data.repository.DataBaseBeerRepository;
import com.example.bimbodemo.domain.model.Results;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class FetchBeersUseCase {
    DataBaseBeerRepository dataBaseBeerRepository;
    @Inject
    public FetchBeersUseCase(DataBaseBeerRepository dataBaseBeerRepository) {
        this.dataBaseBeerRepository = dataBaseBeerRepository;
    }

    public Observable<List<Beer>> fetchBeers() {
        return dataBaseBeerRepository.fetchBeer();
    }
}
