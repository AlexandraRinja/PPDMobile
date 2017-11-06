package com.example.alis.exemplu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alis on 11/5/2017.
 */

public class Recipe implements Serializable{
    private String name;
    private String type;
    private List<String> ingredients;
    public Recipe(String name,String type,List<String> ingredients){
        this.name=name;
        this.type=type;
        this.ingredients=ingredients;
    }
    public Recipe(String name,String type){
        this.name=name;
        this.type=type;
        this.ingredients=new ArrayList<>();
    }
    List<String> getIngredients(){
        return this.ingredients;
    }
    String getName(){
        return this.name;
    }
    String getType(){
        return this.type;
    }
    void setName(String name){
        this.name=name;
    }
    void setType(String type){
        this.type=type;
    }
    void addIngredient(String ingredient){
        this.ingredients.add(ingredient);
    }
    public String toString(){
        return this.name;
    }
}
