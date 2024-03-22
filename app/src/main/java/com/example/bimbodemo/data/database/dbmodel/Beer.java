package com.example.bimbodemo.data.database.dbmodel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Beer.TABLE_NAME)
public class Beer {
   public  static final String TABLE_NAME = "profile";
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "beer_id")
    public Long beerId;

 @ColumnInfo(name = "name")
 public String name;
    @ColumnInfo(name = "image_url")
    public String imageUrl;

 @ColumnInfo(name = "tagline")
 public String tagline;

 @ColumnInfo(name = "description")
 public String description;


}
