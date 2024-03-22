package com.example.bimbodemo.di;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bimbodemo.data.database.db.BimboDataBase;
import com.example.bimbodemo.data.database.dbdao.BeerDataDao;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class DataBaseModule {
    @Provides
    BimboDataBase provideAppDatabase(@ApplicationContext Context appContext) {
        return Room.databaseBuilder(
                appContext,
                BimboDataBase.class,
                "Bimbo"
        ).allowMainThreadQueries().build();
    }

    @Provides
    BeerDataDao provideBeerDataDao(BimboDataBase bimboDataBase) {
        return bimboDataBase.beerDataDao();
    }
}
