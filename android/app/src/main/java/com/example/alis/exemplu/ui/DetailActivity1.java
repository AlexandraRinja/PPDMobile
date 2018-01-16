package com.example.alis.exemplu.ui;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alis.exemplu.R;
import com.example.alis.exemplu.model.Recipe;
import com.example.alis.exemplu.model.Type;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alis on 12/5/2017.
 */

public class DetailActivity1 extends AppCompatActivity {
    EditText et_name,et_description;
    Spinner sp_type;
    Button bt_submit,bt_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        List<Type> types= Arrays.asList(Type.values());
        ArrayAdapter<Type> adapter = new ArrayAdapter<Type>(this, android.R.layout.simple_spinner_item, types);

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("recipesAndroid");

        sp_type = (Spinner)findViewById(R.id.spinnerType);
        sp_type.setAdapter(adapter);

        final Recipe recipe= (Recipe) getIntent().getSerializableExtra("Recipe");
        sp_type.setSelection(recipe.getType().ordinal());
        et_name=findViewById(R.id.nameDTB);
        et_name.setText(recipe.getName());

        et_description=findViewById(R.id.descriptionDTB);
        et_description.setText(recipe.getDescription());

        bt_delete=findViewById(R.id.deleteButton);
        bt_delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("clicks","You Clicked delete");
                databaseReference.child(recipe.getId()).removeValue();
                Intent i=new Intent(DetailActivity1.this, SuccessActivity.class);
                startActivity(i);
            }
        });
        bt_submit=findViewById(R.id.submitButton);
        bt_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("clicks","You Clicked submit");
                recipe.setName(et_name.getText().toString());
                recipe.setDescription(et_description.getText().toString());
                recipe.setType(Type.valueOf(sp_type.getSelectedItem().toString()));
                databaseReference.child(recipe.getId()).setValue(recipe);
                Intent i=new Intent(DetailActivity1.this, SuccessActivity.class);
                startActivity(i);
            }
        });
    }

}
