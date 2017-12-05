package com.example.alis.exemplu.ui;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.alis.exemplu.R;
import com.example.alis.exemplu.db.AppDatabase;
import com.example.alis.exemplu.model.Recipe;
import com.example.alis.exemplu.model.Type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alis on 11/5/2017.
 */

public class SuccessActivity extends AppCompatActivity {
    TextView tv_loginUser;
    EditText et_name,et_description;
    SharedPreferences sharedPreferences;
    Spinner sp_type;
    Button bt_myRecipes,bt_allRecipes,bt_addRecipe,bt_logout,bt_graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        List<Type> types= Arrays.asList(Type.values());
        ArrayAdapter<Type> adapter = new ArrayAdapter<Type>(this, android.R.layout.simple_spinner_item, types);

        Spinner spinType = (Spinner)findViewById(R.id.spinnerType);
        spinType.setAdapter(adapter);

        final SharedPreferences prefs = getSharedPreferences("loginPref", MODE_PRIVATE);
        String nameRestore = prefs.getString("name", null);
        final int id=prefs.getInt("id",-1);

        Log.i("preferences","PREFERENCES"+nameRestore);

        tv_loginUser=findViewById(R.id.loginUser);
        tv_loginUser.append(nameRestore);

        final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"test").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        bt_allRecipes=findViewById(R.id.allreceipesButton);
        bt_allRecipes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("clicks","You Clicked allRecipes");
                List<Recipe> recipes=db.recipeDao().getAll(id);
                Intent i=new Intent(SuccessActivity.this, RecipesNewActivity.class);
                i.putExtra("Recipes", (Serializable) recipes);
                i.putExtra("Flag",0); //0 all
                startActivity(i);
            }
        });
        bt_myRecipes=findViewById(R.id.myreceipesButton);
        bt_myRecipes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("clicks","You Clicked allRecipes");
                List<Recipe> recipes=db.recipeDao().getAllById(id);
                Intent i=new Intent(SuccessActivity.this, RecipesNewActivity.class);
                i.putExtra("Recipes", (Serializable) recipes);
                i.putExtra("Flag",1); //1 my
                startActivity(i);
            }
        });
        et_name=findViewById(R.id.nameTB);
        et_description=findViewById(R.id.descriptionTB);
        sp_type=findViewById(R.id.spinnerType);

        bt_addRecipe=findViewById(R.id.addRecipe);
        bt_addRecipe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("clicks","You Clicked addRecipe");
                Log.i("add","Id:"+id);
                Recipe recipe=new Recipe(et_name.getText().toString(),Type.valueOf(sp_type.getSelectedItem().toString()),et_description.getText().toString(),id);
                db.recipeDao().add(recipe);
                et_name.setText("");
                et_description.setText("");
                Log.i("clicks","SIZE RECIPES"+db.recipeDao().getAll(id).size());
            }
        });
        bt_logout=findViewById(R.id.logout);
        bt_logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                prefs.edit().remove("id");
                prefs.edit().remove("name");
                prefs.edit().remove("email");
                Intent i = new Intent(SuccessActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        bt_graph=findViewById(R.id.graphButton);
        bt_graph.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SuccessActivity.this, GraphActivity.class);
                startActivity(i);
            }
        });
    }
}
