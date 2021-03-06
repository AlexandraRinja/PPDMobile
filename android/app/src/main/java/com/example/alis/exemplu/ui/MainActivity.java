package com.example.alis.exemplu.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.alis.exemplu.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton=findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);


        Button userListButton= findViewById(R.id.userListButton);
        userListButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:{
                Log.i("clicks","You Clicked login");
                Intent i=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                break;
            }
            case R.id.userListButton:{
                Log.i("clicks","You Clicked user");
                Intent i=new Intent(MainActivity.this, UserListActivity.class);
                startActivity(i);
                break;
            }
            default:
                break;
        }
    }
}
