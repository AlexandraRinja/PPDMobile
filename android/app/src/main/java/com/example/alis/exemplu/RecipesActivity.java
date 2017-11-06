package com.example.alis.exemplu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alis on 11/6/2017.
 */

public class RecipesActivity extends AppCompatActivity {
    //AAAA
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        final Repository repo= (Repository) getIntent().getSerializableExtra("Repository");
        final List<Recipe> recipes=repo.getRecipes();
        ListView listView=(ListView) findViewById(R.id.listViewRecipes);
        ArrayAdapter<Recipe> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,recipes);
        listView.setAdapter(arrayAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("listView","You select "+id);
                Intent i=new Intent(RecipesActivity.this, DetailActivity.class);
                Recipe currentRecipe=recipes.get(position);
                i.putExtra("Repository",repo);
                i.putExtra("PosCurrent",position);
                startActivity(i);
            }
        });
    }
}
