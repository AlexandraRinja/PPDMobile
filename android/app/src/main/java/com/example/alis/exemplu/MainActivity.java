package com.example.alis.exemplu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button registerButton=(Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(this);
        Button recipesButton=(Button) findViewById(R.id.recipesButton);
        recipesButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerButton:{
                Log.i("clicks","You Clicked register");
                Intent i=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
                break;
            }
            case R.id.recipesButton:{
                Log.i("clicks","You Clicked recipes");
                Repository repository=new Repository();
                Intent i=new Intent(MainActivity.this, RecipesActivity.class);
                i.putExtra("Repository",repository);
                startActivity(i);
                break;
            }
            default:
                break;
        }
    }
}
