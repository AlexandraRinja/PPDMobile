package com.example.alis.exemplu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alis.exemplu.R;
import com.example.alis.exemplu.model.Recipe;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alis on 12/5/2017.
 */

public class RecipesNewActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    ListView listView;
    List<Recipe> recipes;
    EditText recipeName;
    int MY_RECIPES_ACTIVITY_REQUEST_CODE = 1;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        mAuth = FirebaseAuth.getInstance();
        recipes = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("recipesAndroid");
        databaseReference.keepSynced(true);
        listView = findViewById(R.id.listViewRecipes);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int flag = getIntent().getIntExtra("Flag", -1);
                Log.i("listView", "You select " + flag);
                Recipe recipe = recipes.get(position);
                Log.i("recipe", "You select " + recipe.getName() + " " + recipe.getType() + " " + recipe.getUserId());
                if (mAuth.getCurrentUser().getEmail().equals("rinjaalexandra@gmail.com")) {
                    if (flag == 0) { //0 all
                        Intent i = new Intent(RecipesNewActivity.this, DetailActivity0.class);
                        i.putExtra("Recipe", recipe);
                        startActivity(i);
                    }
                    if (flag == 1) { //1 my
                        Intent i = new Intent(RecipesNewActivity.this, DetailActivity1.class);
                        i.putExtra("Recipe", recipe);
                        startActivity(i);
                    }
                } else {
                    Toast.makeText(RecipesNewActivity.this, "Please buy the premium app for editing", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                recipes.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Recipe recipe = postSnapshot.getValue(Recipe.class);
                    if (recipe.getUserId().equals(mAuth.getCurrentUser().getEmail())) {
                        recipes.add(recipe);
                    }
                }

                ArrayAdapter<Recipe> arrayAdapter = new ArrayAdapter<>(RecipesNewActivity.this, android.R.layout.simple_list_item_1, recipes);
                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
