package com.example.bimbodemo.data.repository;

import com.example.bimbodemo.data.database.dbdao.BeerDataDao;
import com.example.bimbodemo.data.database.dbmodel.Beer;
import com.example.bimbodemo.domain.model.Results;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataBaseBeerRepository {
    BeerDataDao beerDataDao;
    @Inject
    public DataBaseBeerRepository(BeerDataDao beerDataDao){
        this.beerDataDao = beerDataDao;
    }

    public Observable<List<Beer>> fetchBeer(){
        return beerDataDao.fetchBeer();
    }

    public void saveBeer(Beer beer) {
        beerDataDao.insert(beer);
    }

    public void deleteBeer() {
        beerDataDao.deleteAll();
    }

    public Observable<Beer> getBeer(Long beerId){
        return beerDataDao.getBeer(beerId);
    }

}
