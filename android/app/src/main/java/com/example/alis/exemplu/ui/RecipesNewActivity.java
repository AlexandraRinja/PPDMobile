package com.example.alis.exemplu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alis.exemplu.R;
import com.example.alis.exemplu.model.Recipe;

import java.util.List;

/**
 * Created by Alis on 12/5/2017.
 */

public class RecipesNewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipesnew);

        final List<Recipe> recipes= (List<Recipe>) getIntent().getSerializableExtra("Recipes");
        ListView listView=(ListView) findViewById(R.id.listViewRecipes);
        ArrayAdapter<Recipe> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,recipes);
        listView.setAdapter(arrayAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int flag=getIntent().getIntExtra("Flag",-1);
                Log.i("listView","You select " + flag);
                Recipe recipe=recipes.get(position);
                Log.i("recipe","You select " + recipe.getName()+" "+recipe.getType()+" "+recipe.getUserId());
                if(flag==0){ //0 all
                    Intent i=new Intent(RecipesNewActivity.this, DetailActivity0.class);
                    i.putExtra("Recipe",recipe);
                    startActivity(i);
                }
                if(flag==1){ //1 my
                    Intent i=new Intent(RecipesNewActivity.this, DetailActivity1.class);
                    i.putExtra("Recipe",recipe);
                    startActivity(i);
                }
            }
        });
    }
}
