package com.example.alis.exemplu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alis on 11/6/2017.
 */

public class Repository implements Serializable {
    private List<Recipe> recipes;
    public Repository(){
        recipes=new ArrayList<>();
        populateLocalList();
    }
    private void populateLocalList(){
        List<String> ingredients=new ArrayList<String>();
        ingredients.add("aa");
        ingredients.add("bb");
        ingredients.add("cc");
        this.recipes.add(new Recipe("Recipe1","Type1",ingredients));
        this.recipes.add(new Recipe("Recipe2","Type2",ingredients));
        this.recipes.add(new Recipe("Recipe3","Type3",ingredients));
    }
    public List<Recipe> getRecipes(){
        return this.recipes;
    }
}
