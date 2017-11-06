package com.example.alis.exemplu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Alis on 11/6/2017.
 */

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_nameD,et_typeD,et_IngredientsD;
    private int idRecipe;
    private Button submitButton;
    private Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.repository= (Repository) getIntent().getSerializableExtra("Repository");
        this.idRecipe=(int) getIntent().getSerializableExtra("PosCurrent");
        Recipe currentRecipe= repository.getRecipes().get(idRecipe);
        et_nameD= (EditText) findViewById(R.id.nameDTB);
        et_nameD.setText(currentRecipe.getName());

        et_typeD= (EditText) findViewById(R.id.typeDTB);
        et_typeD.setText(currentRecipe.getType());

        et_IngredientsD= (EditText) findViewById(R.id.ingredientsDTB);
        et_IngredientsD.setText(currentRecipe.getIngredients().toString());
        submitButton= (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Recipe currentRecipe=this.repository.getRecipes().get(this.idRecipe);
        currentRecipe.setName(et_nameD.getText().toString());
        currentRecipe.setType(et_typeD.getText().toString());
        Intent i=new Intent(DetailActivity.this, RecipesActivity.class);
        i.putExtra("Repository",this.repository);
        startActivity(i);
    }
}
