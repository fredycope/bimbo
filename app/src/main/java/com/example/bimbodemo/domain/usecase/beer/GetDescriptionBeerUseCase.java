package com.example.bimbodemo.domain.usecase.beer;


import com.example.bimbodemo.data.database.dbmodel.Beer;
import com.example.bimbodemo.data.repository.DataBaseBeerRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetDescriptionBeerUseCase {

    DataBaseBeerRepository dataBaseBeerRepository;
    @Inject
    public GetDescriptionBeerUseCase(DataBaseBeerRepository dataBaseBeerRepository) {
        this.dataBaseBeerRepository = dataBaseBeerRepository;
    }

    public Observable<Beer> getBeer(Long beerId) {
       return dataBaseBeerRepository.getBeer(beerId);
    }
}
