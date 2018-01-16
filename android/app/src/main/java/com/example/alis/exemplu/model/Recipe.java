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


public class Recipe implements Serializable{
    private String id;

    private String name;

    @TypeConverters(TypeConv.class)
    private Type type;

    private String description;
    private float nrStars;

    private String userEmail;

    public Recipe(String id, String name, Type type,String description, String userEmail) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description=description;
        this.userEmail = userEmail;
        this.nrStars=0;
    }

    public Recipe(){

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

    public String getUserId() {
        return userEmail;
    }

    public void setUserId(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
