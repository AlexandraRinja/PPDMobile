package com.example.alis.exemplu.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.io.Serializable;

/**
 * Created by Alis on 11/5/2017.
 */

@Entity(foreignKeys = @ForeignKey(entity = User.class,parentColumns = "id",childColumns = "user_id"))

public class Recipe implements Serializable{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    @TypeConverters(TypeConv.class)
    private Type type;

    private String description;
    private float nrStars;

    @ColumnInfo(name = "user_id")
    private int userId;

    public Recipe(String name, Type type,String description, int userId) {
        this.name = name;
        this.type = type;
        this.description=description;
        this.userId = userId;
        this.nrStars=0;
    }


    public String getName(){
        return this.name;
    }
    public Type getType(){
        return this.type;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setType(Type type){
        this.type=type;
    }
    public String toString(){
        return this.name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNrStars() {
        return nrStars;
    }

    public void setNrStars(float nrStars) {
        this.nrStars = nrStars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
