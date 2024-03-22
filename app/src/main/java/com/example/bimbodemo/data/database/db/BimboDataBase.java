package com.example.bimbodemo.data.database.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.bimbodemo.data.database.dbdao.BeerDataDao;
import com.example.bimbodemo.data.database.dbmodel.Beer;

@Database(entities = {Beer.class}, version = 1, exportSchema = false)
public abstract class BimboDataBase extends RoomDatabase {
public abstract BeerDataDao beerDataDao();
}
