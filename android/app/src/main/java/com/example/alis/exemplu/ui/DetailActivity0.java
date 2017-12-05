package com.example.alis.exemplu.ui;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.alis.exemplu.R;
import com.example.alis.exemplu.db.AppDatabase;
import com.example.alis.exemplu.model.Recipe;

/**
 * Created by Alis on 12/5/2017.
 */

public class DetailActivity0 extends AppCompatActivity {
    TextView tv_name,tv_type,tv_description;
    RatingBar rb_score;
    Button bt_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail0);
        final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"test").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        final Recipe recipe= (Recipe) getIntent().getSerializableExtra("Recipe");
        tv_name=findViewById(R.id.nameTV);
        tv_name.setText(recipe.getName());

        tv_type=findViewById(R.id.typeTV);
        tv_type.setText(recipe.getType().toString());

        tv_description=findViewById(R.id.descriptionTV);
        tv_description.setText(recipe.getDescription());

        rb_score=findViewById(R.id.ratingBar);
        rb_score.setRating(recipe.getNrStars());
        Log.i("starts","Stars: "+recipe.getNrStars());

        bt_submit=findViewById(R.id.submitButton);
        bt_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("clicks","You Clicked submit");
                if(recipe.getNrStars()==0){
                    recipe.setNrStars(rb_score.getRating());
                }
                else {
                    recipe.setNrStars((rb_score.getRating() + recipe.getNrStars()) / 2);
                }
                db.recipeDao().update(recipe);
                Intent i=new Intent(DetailActivity0.this, SuccessActivity.class);
                startActivity(i);
            }
        });
    }
}
