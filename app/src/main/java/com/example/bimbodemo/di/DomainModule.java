package com.example.bimbodemo.di;

import com.example.bimbodemo.data.repository.BeerRepository;
import com.example.bimbodemo.data.repository.DataBaseBeerRepository;
import com.example.bimbodemo.domain.usecase.beer.DeleteBeersUseCase;
import com.example.bimbodemo.domain.usecase.beer.FetchBeersUseCase;
import com.example.bimbodemo.domain.usecase.beer.GetBeersUseCase;
import com.example.bimbodemo.domain.usecase.beer.GetDescriptionBeerUseCase;
import com.example.bimbodemo.domain.usecase.beer.SaveBeersUseCase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class DomainModule {
    @Provides
    public GetBeersUseCase providesBeers(BeerRepository repository )  {
        return new GetBeersUseCase(repository);
    }

    @Provides
    FetchBeersUseCase providesFetchBeers(DataBaseBeerRepository dataBaseBeerRepository){
        return new FetchBeersUseCase(dataBaseBeerRepository);
    }

    @Provides
    SaveBeersUseCase providesSaveBeers(DataBaseBeerRepository dataBaseBeerRepository){
        return new SaveBeersUseCase(dataBaseBeerRepository);
    }

    @Provides
    DeleteBeersUseCase providesDeleteBeers(DataBaseBeerRepository dataBaseBeerRepository){
        return new DeleteBeersUseCase(dataBaseBeerRepository);
    }

    @Provides
    GetDescriptionBeerUseCase providesDescriptionBeers(DataBaseBeerRepository dataBaseBeerRepository){
        return new GetDescriptionBeerUseCase(dataBaseBeerRepository);
    }

}
