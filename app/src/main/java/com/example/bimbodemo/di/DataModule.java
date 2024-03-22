package com.example.bimbodemo.di;

import com.example.bimbodemo.data.database.dbdao.BeerDataDao;
import com.example.bimbodemo.data.network.BeerService;
import com.example.bimbodemo.data.repository.BeerRepository;
import com.example.bimbodemo.data.repository.DataBaseBeerRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class DataModule {
    @Provides
    BeerRepository providesBeerRepository(BeerService beerService ) {
        return new BeerRepository(beerService);
    }

    @Provides
    DataBaseBeerRepository providesDataBaseBeerRepository(BeerDataDao beerDataDao) {
        return new DataBaseBeerRepository(beerDataDao);
    }
}
