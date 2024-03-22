package com.example.bimbodemo.domain.usecase.beer;

import com.example.bimbodemo.data.database.dbmodel.Beer;
import com.example.bimbodemo.data.repository.DataBaseBeerRepository;

import javax.inject.Inject;

public class SaveBeersUseCase {
    DataBaseBeerRepository dataBaseBeerRepository;
    @Inject
    public SaveBeersUseCase(DataBaseBeerRepository dataBaseBeerRepository) {
        this.dataBaseBeerRepository = dataBaseBeerRepository;
    }

    public void saveBeer(Beer beer) {
        dataBaseBeerRepository.saveBeer(beer);
    }
}
