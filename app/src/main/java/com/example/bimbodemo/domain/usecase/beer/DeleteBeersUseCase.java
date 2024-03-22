package com.example.bimbodemo.domain.usecase.beer;

import com.example.bimbodemo.data.repository.DataBaseBeerRepository;

import javax.inject.Inject;

public class DeleteBeersUseCase {
    DataBaseBeerRepository dataBaseBeerRepository;
    @Inject
    public DeleteBeersUseCase(DataBaseBeerRepository dataBaseBeerRepository) {
        this.dataBaseBeerRepository = dataBaseBeerRepository;
    }

    public void deleteBeer() {
        dataBaseBeerRepository.deleteBeer();
    }
}
