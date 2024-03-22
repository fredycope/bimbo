package com.example.bimbodemo.data.database.dbdao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bimbodemo.data.database.dbmodel.Beer;
import com.example.bimbodemo.domain.model.Results;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface BeerDataDao {
    @Insert
    void insert(Beer beer);

    @Query("DELETE FROM "+ Beer.TABLE_NAME)
    void deleteAll();

    @Query("SELECT * FROM " + Beer.TABLE_NAME)
    Observable<List<Beer>> fetchBeer();

    @Query("SELECT * FROM " + Beer.TABLE_NAME +" WHERE beer_id = :beerId")
    Observable<Beer> getBeer(Long beerId);

}
